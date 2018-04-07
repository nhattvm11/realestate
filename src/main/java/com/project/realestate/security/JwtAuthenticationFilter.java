package com.project.realestate.security;

import com.project.realestate.model.JwtAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final static Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
        return super.attemptAuthentication(httpServletRequest, httpServletResponse);
    }

//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
//        if(httpServletRequest.getContextPath().contains("/protected/")){
//            String header = httpServletRequest.getHeader("Authorization");
//
//            if(header == null || !header.startsWith("Bearer ")) {
//            }
//            String authToken = header.substring(7);
//            JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);
//            return getAuthenticationManager().authenticate(authRequest);
//        }
//
//
//    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        super.doFilter(req, res, chain);
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        LOGGER.info("Begin go to Filter.....");
        if(httpServletRequest.getRequestURI().contains("/protected/")){
            String header = httpServletRequest.getHeader("Authorization");

            if(header == null || !header.startsWith("Bearer ")) {
            }
            String authToken = header.substring(7);
            JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);
            SecurityContextHolder.getContext().setAuthentication(authRequest);
            chain.doFilter(httpServletRequest, res);
        }
        chain.doFilter(httpServletRequest, res);
        LOGGER.info("Finish go to Filter.....");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
