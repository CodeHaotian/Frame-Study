package com.yileaf.es;

import com.alibaba.fastjson.JSON;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.collections4.MapUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: Haotian
 * @Date: 2020/2/7 17:09
 * @Description: es Java客户端测试
 */
public class ElasticSearchClientTest {
    private TransportClient client;

    @Before
    public void createClient() throws UnknownHostException {
        System.out.println( "构建客户端对象。。。" );
        //1. 创建 Setting 对象，存放配置信息。主要配置集群名称
        Settings settings = Settings.builder()
                .put( "cluster.name", "my-elasticsearch" ).build();
        //2. 创建Client连接对象
        client = new PreBuiltTransportClient( settings );
        client.addTransportAddress( new TransportAddress( InetAddress.getByName( "127.0.0.1" ), 9301 ) );
        client.addTransportAddress( new TransportAddress( InetAddress.getByName( "127.0.0.1" ), 9302 ) );
        client.addTransportAddress( new TransportAddress( InetAddress.getByName( "127.0.0.1" ), 9303 ) );
    }

    /**
     * 创建索引测试
     */
    @Test
    public void createIndex() {
        client.admin().indices()
                //设置索引名
                .prepareCreate( "hello" )
                //执行操作
                .get();
    }

    /**
     * 绑定映射测试
     */
    @Test
    public void createMappings() throws IOException {
        //构建映射json数据
       /*XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                    .startObject( "article" )
                        .startObject( "properties" )
                            .startObject( "id" )
                                // 5.x版 以后没有String类型，改用text类型
                                .field( "type", "text" )
                                .field( "store", "true" )
                            .endObject()
                            .startObject( "title" )
                                .field( "type", "text" )
                                .field( "store", "true" )
                                .field( "analyzer", "ik_smart" )
                            .endObject()
                            .startObject( "content" )
                                .field( "type", "text" )
                                .field( "store", "true" )
                                .field( "analyzer", "ik_smart" )
                            .endObject()
                        .endObject()
                    .endObject()
                .endObject();
        //创建映射
        client.admin().indices()
                //设置要做映射的索引
                .preparePutMapping( "hello" )
                //设置要做映射的type
                .setType( "article" )
                //映射信息
                .setSource( builder )
                //执行操作
                .get();*/
    }

    /**
     * 添加文档测试
     */
    @Test
    public void addDocument() throws IOException {
        //构建json数据
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field( "id", "1" )
                .field( "title", "零度战姬" )
                .field( "content", "讲述了青井和哉来到杰尼提克斯学院学习战斗技巧的故事。在转学当天遇到背影神似姐姐的校园女王莎缇莱萨的瞬间，和哉的人生就此发生转变。" )
                .endObject();
        //添加文档数据
        client.prepareIndex()
                //设置索引名称
                .setIndex( "hello" )
                //设置类型
                .setType( "article" )
                //设置文档id
                .setId( "1" )
                //设置文档信息
                .setSource( builder )
                //执行操作
                .get();
    }

    /**
     * 对象转json添加文档测试
     */
    @Test
    public void addDocument2() {
        //批量添加数据
        for (int i = 3; i <= 100; i++) {
            //构建json数据
            String jsonDocument = JSON.toJSONString(
                    Article.builder()
                            .id( i )
                            .title( "CLANNAD" + i )
                            .content( "在某个小镇，主角冈崎朋也因家庭因素成为不良少年，一直与春原阳平为伍，在光坂高校过着潦倒的生活，但希望终有一天能够离开所在的小镇。某一天，他在学校坡道前发现了一个止步不前的女孩，在朋也认识了这个名为“古河渚”的女孩后，他的生活开始有了重大的变化。" + i ).build() );
            //添加文档数据
            client.prepareIndex( "hello", "article", i + "" )
                    //设置文档信息
                    .setSource( jsonDocument, XContentType.JSON )
                    //执行操作
                    .get();
        }
    }

    /**
     * 根据id查询文档测试
     */
    @Test
    public void searchById() {
        //构建查询对象
        IdsQueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds( "1", "2" );
        search( queryBuilder );
    }

    /**
     * 根据term查询文档测试
     */
    @Test
    public void searchByTerm() {
        //构建查询对象
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery( "title", "天降" );
        search( queryBuilder );
    }

    /**
     * 根据querystring查询文档测试
     */
    @Test
    public void searchByQueryString() {
        //QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery( "天降战姬" ).defaultField( "title" ); 构建查询对象
        QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery( "天降战姬在小镇" ).defaultField( "content" );
        searchHighlight( queryBuilder, "content" );

    }

    /**
     * 通用查询方法
     *
     * @param queryBuilder 查询条件
     */
    private void search(QueryBuilder queryBuilder) {
        //执行查询
        SearchResponse searchResponse = client.prepareSearch( "hello" )
                .setTypes( "article" )
                //添加搜索添加
                .setQuery( queryBuilder )
                //设置分页信息
                .setFrom( 0 )
                //设置返回结果数量
                .setSize( 6 )
                .get();
        //取到查询结果
        SearchHits searchHits = searchResponse.getHits();
        System.out.println( "查询总记录数：" + searchHits.getTotalHits() );
        searchResponse.getHits().forEach( s -> {
            //System.out.println( s.getSourceAsString() ); 原始数据
            Map<String, Object> document = s.getSourceAsMap();
            MapUtils.verbosePrint( System.out, "查询返回文档数据", document );
        } );
    }

    /**
     * 搜索高亮
     *
     * @param queryBuilder   搜索条件
     * @param highlightField 高亮域
     */
    private void searchHighlight(QueryBuilder queryBuilder, String highlightField) {
        //设置高亮参数
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field( highlightField ).preTags( "<font>" ).postTags( "</font>" );
        //执行查询
        SearchResponse searchResponse = client.prepareSearch( "hello" )
                .setTypes( "article" )
                //添加搜索添加
                .setQuery( queryBuilder )
                //设置分页信息
                .setFrom( 0 )
                //设置返回结果数量
                .setSize( 4 )
                //设置高亮
                .highlighter( highlightBuilder )
                .get();
        //取到查询结果
        SearchHits searchHits = searchResponse.getHits();
        System.out.println( "查询总记录数：" + searchHits.getTotalHits() );
        searchResponse.getHits().forEach( s -> {
            //System.out.println( s.getSourceAsString() ); 原始数据
            Map<String, Object> document = s.getSourceAsMap();
            MapUtils.verbosePrint( System.out, "查询返回文档数据", document );
            Map<String, HighlightField> highlightFields = s.getHighlightFields();
            MapUtils.verbosePrint( System.out, "高亮结果", highlightFields );
        } );
    }

    @After
    public void closeClient() {
        System.out.println( "关闭客户端对象。。。" );
        client.close();
    }
}
