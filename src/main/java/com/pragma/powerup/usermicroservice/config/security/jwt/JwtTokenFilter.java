package com.pragma.powerup.usermicroservice.config.security.jwt;


import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getToken(req);
        if (token != null && jwtProvider.validate(token)) {
            String userName = jwtProvider.getUserNameFromToken(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(), null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
