package org.softuni.exam.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/home","/logout","/schedule","/print/*","/details/*"})
public class GuestUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userId = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("user-id");

        if(userId == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/index");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
