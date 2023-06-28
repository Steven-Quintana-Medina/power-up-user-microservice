package com.pragma.powerup.usermicroservice.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.DniNumberAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserNotFoundException;
import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidDniException;
import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidPhoneException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UnderAgeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.config.Constants.*;


@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleMailAlreadyExistsException(
            MailAlreadyExistsException mailAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, MAIL_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(DniNumberAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> dniNumberAlreadyExistsException(
            DniNumberAlreadyExistsException dniNumberAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DNI_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(UnderAgeException.class)
    public ResponseEntity<Map<String, String>> handleUnderAgeException(
            UnderAgeException underAgeException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, UNDER_AGE));
    }


    @ExceptionHandler(InvalidPhoneException.class)
    public ResponseEntity<Map<String, String>> handleInvalidPhoneException(
            InvalidPhoneException invalidPhoneException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_PHONE));
    }

    @ExceptionHandler(InvalidDniException.class)
    public ResponseEntity<Map<String, String>> handleInvalidDniException(
            InvalidDniException invalidDniException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_DNI));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, WRONG_CREDENTIALS_MESSAGE));
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Map<String, String>> handleNumberFormatException(NumberFormatException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_NUMBER));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PERSON_NOT_FOUND));
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Map<String, String>> handleFormatDateException(DateTimeParseException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_DATE_FORMAT));
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Map<String, String>> handleJsonProcessingException() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CONFLICT_MESSAGE));
    }
}
