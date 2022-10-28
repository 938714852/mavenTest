package com.ustc.maven;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      1. String getParameter(String name):根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println("username:  " + username);
        String password = request.getParameter("password");
        System.out.println("password:  " + password);
//      2. String[] getParameterValues(String name):根据参数名称获取参数值的数组
        String[] loves = request.getParameterValues("love");
        System.out.println("love:  " + Arrays.toString(loves));
        System.out.println("-----------------------");
//      3. Enumeration<String> getParameterNames():获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paraName = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(paraName);
            System.out.println(paraName + ":" + Arrays.toString(parameterValues));
        }
        System.out.println("-----------------------");

//      4. Map<String,String[]> getParameterMap():获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
