package com.project.realestate.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {

    private String id;
    private String username;
    private String password;
    private String token;

    private List<GrantedAuthority> grantedAuthorities;

    public CustomUserDetail(String username, String password, List<GrantedAuthority> grantedAuthorities) {
        this.username = username;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
        this.token = token;
    }

    public CustomUserDetail(String id, String username, String token, List<GrantedAuthority> grantedAuthorities) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.grantedAuthorities = grantedAuthorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
