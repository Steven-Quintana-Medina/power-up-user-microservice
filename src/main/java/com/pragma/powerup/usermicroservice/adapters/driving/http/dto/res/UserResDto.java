package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResDto {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String mail;
}
