package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.pragma.powerup.usermicroservice.domain.utils.UserConstansTest.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    @Test
    void testSaveClient() {
        User USER = new User(
                1L,
                "Juan",
                "Pérez",
                "12345678",
                "+573004015479",
                "01-01-2000",
                "juan.perez@example.com",
                "115315",
                4L);
        userUseCase.saveClient(USER);
        verify(userPersistencePort).saveUser(USER);
    }

    @Test
    void testSaveOwner() {
        User USER = new User(
                1L,
                "Juan",
                "Pérez",
                "12345678",
                "+573004015479",
                "01-01-2000",
                "juan.perez@example.com",
                "115315",
                4L);
        userUseCase.saveOwner(USER);
        verify(userPersistencePort).saveUser(USER);
    }

    @Test
    void testSaveEmployee() {
        User USER = new User(
                1L,
                "Juan",
                "Pérez",
                "12345678",
                "+573004015479",
                "01-01-2000",
                "juan.perez@example.com",
                "115315",
                4L);
        userUseCase.saveEmployee(USER);
        verify(userPersistencePort).saveUser(USER);
    }

    @Test
    void testValidUserOwner() {
        userUseCase.validUserOwner(VALID_USER_OWNER);
        verify(userPersistencePort).validUser(VALID_USER_OWNER, 2L);
    }

    @Test
    void testValidUserEmployee() {
        userUseCase.validUserEmployee(VALID_USER_EMPLOYEE);
        verify(userPersistencePort).validUser(VALID_USER_EMPLOYEE, 3L);
    }

    @Test
    void testGetPhoneUserClient(){
        userUseCase.getUserClient(VALID_USER_CLIENT);
        verify(userPersistencePort).getUserClient(VALID_USER_CLIENT);
    }

    @Test
    void testGetClientAndEmployee(){
        userUseCase.getClientAndEmployee(VALID_USER_CLIENT,VALID_USER_EMPLOYEE);
        verify(userPersistencePort).getClientAndEmployee(VALID_USER_CLIENT,VALID_USER_EMPLOYEE);
    }
}
