package com.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * @Author：Haotian
 * @Date：2019/5/19 22:06
 */
@Getter
@Setter
public class UploadAction extends ActionSupport {

    private String username;
    private String password;
    /**
     * Struts2会自动把数据转成文件对象
     */
    private File[] photo;
    /**
     * 文件的类类型
     */
    private String[] photoContentType;
    /**
     * 文件名称
     */
    private String[] photoFileName;


    public String upload() {
        //遍历文件
        for (int i = 0; i < photo.length; i++) {
            //获取文件
            File file = photo[i];
            System.out.println( "文件临时路径:" + file );
            System.out.println( "文件类型:" + photoContentType[i] );
            System.out.println( "文件名:" + photoFileName[i] );
            //to do...把文件保存起来
        }
        return NONE;
    }
}
