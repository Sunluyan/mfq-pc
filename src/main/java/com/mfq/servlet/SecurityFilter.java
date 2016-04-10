package com.mfq.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 权限相关控制
 * @author xingyongshan
 *
 */
public class SecurityFilter implements Filter {

    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {

            chain.doFilter(request, response);
        } catch (Exception e) {
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        
    }
}
