package day0831;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter("/testFilter")
@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter@doFilter...");
        chain.doFilter(request, response);
        System.out.println("MyFilter@doFilter...---after---");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
