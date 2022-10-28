package com.ustc.maven;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo1 extends HttpServlet {
//为保证线程安全，尽量使用局部变量
    @Override
    public void init() throws ServletException {
        System.out.println("init。。。。");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("doGet方法");
        System.out.println("通用请求123");
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("doPost方法");
        System.out.println("从put走到doGet通用方法");

    }
}
