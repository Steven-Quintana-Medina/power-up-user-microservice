package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.UserReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.config.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.config.Constants.*;

@Tag(name = "User Management", description = "API endpoints for managing users")
@RestController
@RequestMapping("/user/")
@SecurityRequirement(name = "jwt")
@RequiredArgsConstructor
public class UserController {
    private final IUserHandler userHandler;

    //post
    @Operation(summary = "Add a new client",
            responses = {
                    @ApiResponse(responseCode = "201", description = PERSON_CREATED_MESSAGE,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Message"))),
                    @ApiResponse(responseCode = "409", description = SWAGGER_PERSON_ERROR,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("create-client/")
    public ResponseEntity<Map<String, String>> saveClient(@RequestBody UserReqDto userReqDto) {
        userHandler.saveClient(userReqDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, PERSON_CREATED_MESSAGE));
    }

    @Operation(summary = "Add a new owner",
            responses = {
                    @ApiResponse(responseCode = "201", description = PERSON_CREATED_MESSAGE,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Message"))),
                    @ApiResponse(responseCode = "409", description = SWAGGER_PERSON_ERROR,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "401", description = WRONG_CREDENTIALS_MESSAGE,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @PostMapping("create-owner/")
    public ResponseEntity<Map<String, String>> saveOwmer(@RequestBody UserReqDto userReqDto) {
        userHandler.saveOwner(userReqDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, PERSON_CREATED_MESSAGE));
    }

    @Operation(summary = "Add a new employee",
            responses = {
                    @ApiResponse(responseCode = "201", description = PERSON_CREATED_MESSAGE,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Message"))),
                    @ApiResponse(responseCode = "409", description = SWAGGER_PERSON_ERROR,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "401", description = WRONG_CREDENTIALS_MESSAGE,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @PostMapping("create-employee/")
    public ResponseEntity<Map<String, String>> saveEmployee(@RequestBody UserReqDto userReqDto) {
        userHandler.saveEmployee(userReqDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, PERSON_CREATED_MESSAGE));
    }

    //get
    @Operation(summary = "valid owner",
            responses = {
                    @ApiResponse(responseCode = "200", description = MESSAGE_SUCCESS,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/MessageBoolean"))),
                    @ApiResponse(responseCode = "401", description = PERSON_NOT_FOUND,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/MessageBoolean"))),
                    @ApiResponse(responseCode = "404", description = WRONG_CREDENTIALS_MESSAGE,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @GetMapping("/owner/{id}")
    public ResponseEntity<Boolean> getUserOwner(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userHandler.getUserOwner(id));
    }

    @Operation(summary = "valid employee",
            responses = {
                    @ApiResponse(responseCode = "200", description = MESSAGE_SUCCESS,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/MessageBoolean"))),
                    @ApiResponse(responseCode = "401", description = PERSON_NOT_FOUND,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/MessageBoolean"))),
                    @ApiResponse(responseCode = "404", description = WRONG_CREDENTIALS_MESSAGE,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @GetMapping("/employee/{id}")
    public ResponseEntity<Boolean> getUserEmployee(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userHandler.getUserEmployee(id));
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<String> getUserClient(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userHandler.getUserClient(id));
    }

}
