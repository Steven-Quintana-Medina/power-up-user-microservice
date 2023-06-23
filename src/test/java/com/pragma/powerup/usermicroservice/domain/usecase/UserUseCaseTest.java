package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.pragma.powerup.usermicroservice.domain.utils.UserConstansTest.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    @Test
    public void testSaveClient() {
        userUseCase.saveClient(USER);
        verify(userPersistencePort).saveUser(USER);
    }

    @Test
    public void testSaveOwner() {
        userUseCase.saveOwner(USER);
        verify(userPersistencePort).saveUser(USER);
    }

    @Test
    public void testSaveEmpoyee() {
        userUseCase.saveEmployee(USER);
        verify(userPersistencePort).saveUser(USER);
    }

    @Test
    public void testGetUserOwner() {
        userUseCase.getUserOwner(VALID_USER_OWNER);
        verify(userPersistencePort).validUser(VALID_USER_OWNER,2L);
    }
}
