package com.pragma.powerup.usermicroservice.config;

public class Constants {

    //response key
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String DESCRIPTION_MESSAGE_KEY = "http 200 type messages";
    public static final String DESCRIPTION_MESSAGE_BOOLEAN_KEY = "true for http 200 message types and false for http 400 message types";
    public static final String DESCRIPTION_ERROR_KEY = "http 400 type messages";
    //response code 200
    public static final String PERSON_CREATED_MESSAGE = "User created successfully";
    public static final String MESSAGE_SUCCESS = "SUCCESS";
    //claves
    public static final String PHONE_CLAVE = "phone";
    public static final String VALID_USER_CLAVE = "validUser";
    //response code 400
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String CONFLICT_MESSAGE = "There was a problem processing your request";
    public static final String DNI_ALREADY_EXISTS_MESSAGE = "A user already exists with this dni";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A person with that mail already exists";
    public static final String INVALID_PHONE = "A person has an invalid phone number";
    public static final String INVALID_DNI = "A person has an invalid dni";
    public static final String UNDER_AGE = "A person is a minor";
    public static final String INVALID_NUMBER = "The value entered is not a valid number";
    public static final String PERSON_NOT_FOUND = "Person not found";
    public static final String INVALID_DATE_FORMAT = "INVALID DATE FORMAT, THE FORMAT MUST BE DD/MM/YYYY";
    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";


    //swagger
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "2.0.4";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "https://springdoc.org/v2/";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
    public static final String SWAGGER_PERSON_ERROR = "Problems registering a person";
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
}
