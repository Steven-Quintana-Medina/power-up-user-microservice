package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class PrincipalUser implements UserDetails {
    private String id;
    private String mail;
    private String password;
    private String rol;

    public PrincipalUser(Long id , String mail, String password,String rol) {
        this.id = id.toString();
        this.mail = mail;
        this.password = password;
        this.rol = rol;
    }

    public static PrincipalUser build(UserEntity user, String rol) {
        return new PrincipalUser(user.getId(),user.getMail(), user.getPassword(), rol);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(rol));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }
}
