package day0831;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

//@WebFilter("/testFilter")
//@WebFilter(filterName = "ZFilter")
public class ZFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("ZFilter.doFilter");
        chain.doFilter(request, response);
        System.out.println("ZFilter.doFilter...---after---");
    }
}
