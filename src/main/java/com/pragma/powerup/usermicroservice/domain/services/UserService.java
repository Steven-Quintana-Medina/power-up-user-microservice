package com.pragma.powerup.usermicroservice.domain.services;

import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidDniException;
import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidPhoneException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UnderAgeException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static com.pragma.powerup.usermicroservice.domain.utils.Constants.REGEX_NUM_VALUES;
import static com.pragma.powerup.usermicroservice.domain.utils.Constants.REGEX_VALID_PHONE;

public class UserService {
    public static void validPhone(String phone) {
        if (!phone.matches(REGEX_VALID_PHONE)) {
            throw new InvalidPhoneException();
        }
    }

    public static void validAge(String age) {
        if (isMinor(age)) {
            throw new UnderAgeException();
        }
    }

    public static void validDni(String nit) {
        if (!nit.matches(REGEX_NUM_VALUES)) {
            throw new InvalidDniException();
        }
    }

    private static boolean isMinor(String dateString) {
        LocalDate birthDate = parseDate(dateString);
        LocalDate now = LocalDate.now();
        Period age = Period.between(birthDate, now);
        return age.getYears() < 18;
    }

    private static LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, formatter);
    }
}
