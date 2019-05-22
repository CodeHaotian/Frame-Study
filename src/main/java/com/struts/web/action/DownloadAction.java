package com.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 步骤：
 * 1.写个Action
 * 2.在Action写一个输入流属性，提供get方法
 * 3.在Action中写个downlaod方法，给inputStream赋值
 * 4.写struts.xml配置文件，添加action
 * 5.result中type写stream,以流的形式把数据返回给客户端面
 * 6.在result中添加3个参数
 * inputName
 * contentDisposition
 * contentType
 *
 * @Author：Haotian
 * @Date：2019/5/20 16:26
 */
public class DownloadAction extends ActionSupport {
    private InputStream inputStream;
    private String filename;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFilename() {
        return filename;
    }

    public String download() throws FileNotFoundException {
        filename = "73518990_p0.jpg";
        //1.路径
        String path = "E:\\图片\\" + filename;

        //2.给输入流赋值
        inputStream = new FileInputStream( path );

        //3.以前通过outputStream返回数据给客户端
        //struts不需要自己写数据给客户端
        return SUCCESS;
    }
}
