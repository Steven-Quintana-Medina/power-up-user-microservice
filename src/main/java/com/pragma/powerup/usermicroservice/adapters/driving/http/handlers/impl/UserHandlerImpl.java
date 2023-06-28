package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.UserReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res.UserResDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.req.IUserReqMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.res.IUserResMapper;
import com.pragma.powerup.usermicroservice.config.converters.IJsonConverter;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pragma.powerup.usermicroservice.config.Constants.PHONE_CLAVE;
import static com.pragma.powerup.usermicroservice.config.Constants.VALID_USER_CLAVE;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserReqMapper userReqMapper;
    private final IUserResMapper userResMapper;
    private final IJsonConverter jsonConverters;

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
    public String validUserOwner(Long id) {
        return jsonConverters.jsonNodeConverters(VALID_USER_CLAVE, userServicePort.validUserOwner(id));
    }

    @Override
    public String validUserEmployee(Long id) {
        return jsonConverters.jsonNodeConverters(VALID_USER_CLAVE, userServicePort.validUserEmployee(id));
    }

    @Override
    public String getUserClient(Long id) {
        UserResDto userResDto = userResMapper.toUserRes(userServicePort.getUserClient(id));
        return jsonConverters.jsonConverters(userResDto);
    }

    @Override
    public String getClientAndEmployee(Long idClient, Long idEmployee) {
        List<UserResDto> userResDto = userResMapper.toUserRes(userServicePort.getClientAndEmployee(idClient, idEmployee));
        return jsonConverters.jsonConverters(userResDto);
    }
}
