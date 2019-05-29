package com.ssm.study.web.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：Haotian
 * @Date：2019/5/29 22:23
 */
public class HttpController implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute( "name", "琳琳" );
        request.getRequestDispatcher( "/WEB-INF/views/user/userlist.jsp" ).forward( request, response );

    }
}
