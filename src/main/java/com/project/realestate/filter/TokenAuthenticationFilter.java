package com.project.realestate.filter;

import com.project.realestate.helper.TokenHelper;
import com.project.realestate.model.TokenBasedAuthentication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private static final String TOKEN = "token";

    private final Log LOG = LogFactory.getLog(this.getClass());

    private TokenHelper tokenHelper;

    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenHelper tokenHelper, UserDetailsService userDetailsService) {
        this.tokenHelper = tokenHelper;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated() ) {
            Cookie[] cookies = request.getCookies();
            String authTokenCk = null;
            if(cookies != null) {
                authTokenCk = getTokenFromCookie(cookies);
            }


            String username;
            String authToken = tokenHelper.getToken(request);

            if (authTokenCk != null) {
                // get username from token
                username = tokenHelper.getUsernameFromToken(authTokenCk);
                if (username != null) {
                    // get user
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (tokenHelper.validateToken(authTokenCk, userDetails)) {
                        // create authentication
                        TokenBasedAuthentication tkbAuthentication = new TokenBasedAuthentication(userDetails);
                        tkbAuthentication.setToken(authTokenCk);
                        SecurityContextHolder.getContext().setAuthentication(tkbAuthentication);
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }

    public String getTokenFromCookie(Cookie[] cookies) {
        for (Cookie ck : cookies) {
            if(ck.getName().equals(TOKEN)) {
                return ck.getValue();
            }
        }
        return null;
    }

}