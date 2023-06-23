package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.UserReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.req.IUserReqMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserReqMapper userReqMapper;

    @Override
    public void saveClient(UserReqDto userReqDto) {
        userServicePort.saveClient(userReqMapper.toUser(userReqDto));
    }

    @Override
    public void saveOwner(UserReqDto userReqDto) {
        userServicePort.saveOwner(userReqMapper.toUser(userReqDto));
    }

    @Override
    public void saveEmployee(UserReqDto userReqDto) {
        userServicePort.saveEmployee(userReqMapper.toUser(userReqDto));
    }

    @Override
    public boolean getUserOwner(Long id) {
        return userServicePort.getUserOwner(id);
    }

    @Override
    public boolean getUserEmployee(Long id) {
        return userServicePort.getUserEmployee(id);
    }

    @Override
    public String getUserClient(Long id) {
        return userServicePort.getUserClient(id);
    }
}
