package com.hibernate.tieba.web.action;

import com.hibernate.tieba.model.Topic;
import com.hibernate.tieba.service.TopicService;
import com.hibernate.tieba.service.impl.TopicServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/24 14:09
 */
public class TopicAction extends ActionSupport implements ModelDriven<Topic> {
    private Topic topic = new Topic();
    /**
     * 属性提供get方法，数据会自动存在值栈中
     */
    @Getter
    private List<Topic> topicList;
    private TopicService service = new TopicServiceImpl();

    /**
     * 返回话题列表界面
     *
     * @return topic_list
     */
    public String list() {
        //获取数据,存在ValueStack【值栈】
        topicList = service.getAll( null );
        return "list";
    }

    public String save() {
        //1.表单数据封装
        //帖子创建时间
        topic.setCreateDate( new Date() );
        //帖子的id地址
        //action怎么获取请求对象
        topic.setIpAddr( ServletActionContext.getRequest().getRemoteAddr() );

        //2.调用service
        service.save( topic );

        //获取数据
        List<Topic> topicList = service.getAll( null );
        ActionContext.getContext().put( "topicList", topicList );

        return "list";
    }

    @Override
    public Topic getModel() {
        return topic;
    }

    /**
     * 通过帖子关键字探索相关数据
     *
     * @return
     */
    @Setter
    private String key;

    public String search() {
        System.out.println( "搜索的关键字:" + key );
        topicList = service.getAll( key );
        return "list";
    }
}
