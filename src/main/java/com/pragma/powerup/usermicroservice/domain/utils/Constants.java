package com.pragma.powerup.usermicroservice.domain.utils;

public class Constants {
    //regex
    public static final String REGEX_NUM_VALUES = "^\\d+$";
    public static final String REGEX_VALID_PHONE = "^\\+\\d{12}$";
    public static final Long OWNER_ROLE_ID = 2L;

    //id roles
    public static final Long EMPLOYEE_ROLE_ID = 3L;
    public static final Long CLIENT_ROLE_ID = 4L;
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

}
