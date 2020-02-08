import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yileaf.es.dao.ArticleDao;
import com.yileaf.es.entity.Article;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Haotian
 * @Date: 2020/2/8 16:18
 * @Description: es 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataElasticSearchTest {
    @Autowired
    private ArticleDao articleDao; //此对象实际存在，为 idea 提示问题
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 创建索引测试
     */
    @Test
    public void createIndex() {
        elasticsearchTemplate.createIndex( Article.class );
        //elasticsearchTemplate.putMapping( Article.class ); 此用于配置映射
    }

    /**
     * 添加/修改 文档测试
     */
    @Test
    public void addDocument() {
        //准备数据
        Article article = Article.builder()
                //保证id相同再次添加数据即为修改
                .id( 1 )
                .title( "椎名真白" )
                .content( "出自樱花庄的宠物女孩,英日混血儿，拥有通透白皙的肌肤，微微的凤眼看起来有些成熟，迈步走起来像西表山猫。" ).build();
        //将数据存入索引库
        articleDao.save( article );
    }

    @Test
    public void addMoreDocument() {
        for (int i = 11; i <= 20; i++) {
            //准备数据
            Article article = Article.builder()
                    //保证id相同再次添加数据即为修改
                    .id( i )
                    .title( i + "莎缇莱萨·L·布丽姬" )
                    .content( i + "自尊心极强，冷若冰霜的外表下，内心其实相当柔弱，非常喜欢吃汉堡，不管什么时候都是吃汉堡。" ).build();
            //将数据存入索引库
            articleDao.save( article );
        }
    }

    /**
     * 删除文档测试
     */
    @Test
    public void deleteDocumentById() {
        articleDao.deleteById( 1L );
        //articleDao.deleteAll(); 删除全部
    }

    /**
     * 查询文档测试
     */
    @Test
    public void findAllDocument() {
        //查询所有文档
        Iterable<Article> allDocument = articleDao.findAll();
        //遍历输出查看,这里借助 fastjson 美化输出格式
        System.out.println( JSON.toJSONString( allDocument, SerializerFeature.PrettyFormat ) );
        //allDocument.forEach( System.out::println ); 普通方式打印
    }

    /**
     * 查询文档测试
     */
    @Test
    public void findDocumentById() {
        //查询指定id文档
        Optional<Article> article = articleDao.findById( 10L );
        System.out.println( JSON.toJSONString( article, SerializerFeature.PrettyFormat ) );
    }

    /**
     * 自定义查询title方法测试
     */
    @Test
    public void findDocumentByTitle() {
        //查询指定标题文档
        List<Article> articles = articleDao.findByTitle( "真白" );
        System.out.println( JSON.toJSONString( articles, SerializerFeature.PrettyFormat ) );
    }

    /**
     * 自定义查询title或content方法测试
     */
    @Test
    public void findDocumentByTitleOrContent() {
        //查询指定标题或者内容文档
        List<Article> articles = articleDao.findByTitleOrContent( "真白", "汉堡" );
        System.out.println( JSON.toJSONString( articles, SerializerFeature.PrettyFormat ) );
    }

    /**
     * 自定义查询title或content方法并分页测试
     */
    @Test
    public void findDocumentByTitleOrContent2() {
        //设置分页信息
        Pageable page = PageRequest.of( 1, 6 );
        //查询指定标题或者内容文档
        List<Article> articles = articleDao.findByTitleOrContent( "真白与汉堡肉", "汉堡", page );
        System.out.println( JSON.toJSONString( articles, SerializerFeature.PrettyFormat ) );
    }

    /**
     * 原生查询方式
     */
    @Test
    public void testNativeSearchQuery() {
        //创建查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(
                        //设置查询内容与查询域
                        QueryBuilders
                                .queryStringQuery( "真白与布丽姬" ).defaultField( "title" ) )
                .withPageable(
                        PageRequest
                                .of( 0, 4 ) )
                .withSort(
                        //设置排序字段与排序规则
                        SortBuilders
                                .fieldSort( "id" ).order( SortOrder.ASC ) )
                .build();
        //执行查询
        List<Article> articles = elasticsearchTemplate.queryForList( query, Article.class );
        System.out.println( JSON.toJSONString( articles, SerializerFeature.PrettyFormat ) );
    }
}