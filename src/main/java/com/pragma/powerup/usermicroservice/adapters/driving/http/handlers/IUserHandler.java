package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.UserReqDto;

public interface IUserHandler {
    void saveClient(UserReqDto userReqDto);

    void saveOwner(UserReqDto userReqDto);

    void saveEmployee(UserReqDto userReqDto);

    String validUserOwner(Long id);

    String validUserEmployee(Long id);

    String getUserClient(Long id);

    String getClientAndEmployee(Long idClient, Long idEmployee);
}
