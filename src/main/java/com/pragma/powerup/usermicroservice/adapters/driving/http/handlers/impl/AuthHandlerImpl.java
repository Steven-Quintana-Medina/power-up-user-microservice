package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.LoginReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res.JwtResDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IAuthHandler;
import com.pragma.powerup.usermicroservice.config.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthHandlerImpl implements IAuthHandler {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public JwtResDto login(LoginReqDto loginReqDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReqDto.getMail(), loginReqDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        return new JwtResDto(jwt);
    }
}
