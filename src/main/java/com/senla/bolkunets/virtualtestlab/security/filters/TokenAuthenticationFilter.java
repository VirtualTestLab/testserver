package com.senla.bolkunets.virtualtestlab.security.filters;

import com.senla.bolkunets.virtualtestlab.security.services.TokenAuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class TokenAuthenticationFilter extends GenericFilterBean {

    private TokenAuthenticationService tokenAuthenticationService;

    public TokenAuthenticationFilter(TokenAuthenticationService tokenAuthenticationService) {
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        Authentication authenticate = tokenAuthenticationService.authenticate((HttpServletRequest) req);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        chain.doFilter(req, res);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
