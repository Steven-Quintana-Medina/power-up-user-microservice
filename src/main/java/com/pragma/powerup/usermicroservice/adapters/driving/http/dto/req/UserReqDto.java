package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserReqDto {
    @Schema(title = "Name", description = "Name of a person", example = "Juan")
    @NotBlank
    private String name;

    @NotBlank
    @Schema(title = "Name", description = "Last name of a person", example = "Castillo")
    private String surname;

    @NotBlank
    @Schema(title = "DniNumber", description = "dni of the person in numerical format", example = "1556461")
    private String dniNumber;

    @NotBlank
    @Schema(title = "Phone", description = "Phone of a person in numerical format", example = "+578245648274")
    private String phone;

    @NotBlank
    @Schema(title = "BirthDate", description = "BirthDate of a person in format DD-MM-YYYY", example = "03-05-2005")
    private String birthDate;

    @NotBlank
    @Schema(title = "email", description = "email of a person", example = "Juan@gmail.com")
    private String mail;

    @NotBlank
    @Schema(title = "password", description = "password of a person", example = "admin")
    private String password;
}
