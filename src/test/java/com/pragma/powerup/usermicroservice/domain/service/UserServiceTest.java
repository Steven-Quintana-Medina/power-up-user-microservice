package com.pragma.powerup.usermicroservice.domain.service;

import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidDniException;
import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidPhoneException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UnderAgeException;
import com.pragma.powerup.usermicroservice.domain.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.format.DateTimeParseException;

import static com.pragma.powerup.usermicroservice.domain.utils.UserConstansTest.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Test
    void testInvalidPhoneNumber() {
        for (String invalidPhoneNumber : INVALID_PHONE_NUMBERS) {
            assertThrows(InvalidPhoneException.class, () -> UserService.validPhone(invalidPhoneNumber));
        }
    }

    @Test
    void testInvalidFormatBirthDate() {
        for (String invalidBirthDate : INVALID_BIRTH_DATES_FORMAT) {
            assertThrows(DateTimeParseException.class, () -> UserService.validAge(invalidBirthDate));
        }
    }

    @Test
    void testInvalidBirthDate(){
        assertThrows(UnderAgeException.class,() -> UserService.validAge(INVALID_BIRTH_DATE));
    }

    @Test
    void inValidDni() {
        for (String invalidDninNumber : INVALID_DNI_NUMBERS) {
            assertThrows(InvalidDniException.class, () -> UserService.validDni(invalidDninNumber));
        }
    }
}
