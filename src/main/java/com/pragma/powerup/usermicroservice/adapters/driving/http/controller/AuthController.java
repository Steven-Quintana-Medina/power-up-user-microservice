package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.LoginReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res.JwtResDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IAuthHandler;
import com.pragma.powerup.usermicroservice.config.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.config.Constants.MESSAGE_SUCCESS;
import static com.pragma.powerup.usermicroservice.config.Constants.PERSON_NOT_FOUND;


@Tag(name = "Authentication", description = "Endpoints related to user authentication")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthHandler authHandler;

    @Operation(summary = "login",
            responses = {
                    @ApiResponse(responseCode = "200", description = MESSAGE_SUCCESS,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Message"))),
                    @ApiResponse(responseCode = "404", description = PERSON_NOT_FOUND,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginReqDto loginReqDto) {
        JwtResDto token = authHandler.login(loginReqDto);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token.getToken());
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, "valid user"));
    }
}
