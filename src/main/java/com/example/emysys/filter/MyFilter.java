package com.example.emysys.filter;

import javax.servlet.*;
import java.io.IOException;
/**
 * ClassName: MyFilter.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 22:17
 * Description: 自定义 Filter
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
