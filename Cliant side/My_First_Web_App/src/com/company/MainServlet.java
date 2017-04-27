package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hackeru on 4/19/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected  void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().write("hello!");
        String queryString = request.getQueryString();
        System.out.println(queryString);
        Map<String, String> qs = new HashMap<>();
        if (qs != null) {
            String[] keyValues = queryString.split("&");
            for (String keyValue : keyValues) {
                String[] keyValuePair = keyValue.split("=");
                if (keyValuePair.length != 2)
                    continue;
                qs.put(keyValuePair[0], keyValuePair[1]);
            }
        }
        System.out.println(qs.get("username"));
        System.out.println(qs.get("password"));
    }
}
