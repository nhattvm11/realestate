package com.project.realestate.security;

import com.project.realestate.entity.User;
import com.project.realestate.exception.ConfirmationException;
import com.project.realestate.exception.TokenInvalidException;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.exception.UsernameExistException;
import com.project.realestate.model.CustomUserDetail;
import com.project.realestate.model.JwtAuthenticationToken;
import com.project.realestate.model.TokenBasedAuthentication;
import com.project.realestate.service.CustomUserDetailService;
import com.project.realestate.service.JwtTokenService;
import com.project.realestate.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    JwtTokenService jwtTokenService;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    UserService userService;

    public JwtAuthenticationFilter() {
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
        return super.attemptAuthentication(httpServletRequest, httpServletResponse);
    }

    private String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Bearer ");
        if ( authHeader != null && authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }
        return null;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String error = "";
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        String authToken = getToken(httpServletRequest);
        if(authToken != null) {
            try {
                String userId = jwtTokenService.verifyToken(authToken);
                User user = userService.getUserById(userId);
                if(user.getUsername() != null) {
                    UserDetails userDetail = customUserDetailService.loadUserByUsername(user.getUsername());
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetail);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    error = "Username from token can't be found in DB.";
                }
            } catch (TokenInvalidException e) {
                e.printStackTrace();
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            } catch (UsernameExistException e) {
                e.printStackTrace();
            } catch (ConfirmationException e) {
                e.printStackTrace();
            }
        } else {
            error = "Authentication failed - no Bearer token provided.";
        }
        if( ! error.equals("")){
            System.out.println(error);
        }
        chain.doFilter(httpServletRequest, res);
    }

//        @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
////        super.doFilter(req, res, chain);
//        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
//        LOGGER.info("Begin go to Filter.....");
//        if(httpServletRequest.getRequestURI().contains("/protected/")){
//            String header = httpServletRequest.getHeader("Authorization");
//
//            if(header == null || !header.startsWith("Bearer ")) {
//            }
//            String authToken = header.substring(7);
//            JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);
//            SecurityContextHolder.getContext().setAuthentication(authRequest);
//            chain.doFilter(httpServletRequest, res);
//        }
//        chain.doFilter(httpServletRequest, res);
//        LOGGER.info("Finish go to Filter.....");
//    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
