package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.services.UserService;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;

import java.util.List;

import static com.pragma.powerup.usermicroservice.domain.utils.Constants.*;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveClient(User user) {
        UserService.validPhone(user.getPhone());
        user.setIdRol(CLIENT_ROLE_ID);
        userPersistencePort.saveUser(user);
    }

    @Override
    public void saveOwner(User user) {
        UserService.validDni(user.getDniNumber());
        UserService.validAge(user.getBirthDate());
        UserService.validPhone(user.getPhone());
        user.setIdRol(OWNER_ROLE_ID);
        userPersistencePort.saveUser(user);
    }

    @Override
    public void saveEmployee(User user) {
        UserService.validDni(user.getDniNumber());
        UserService.validAge(user.getBirthDate());
        UserService.validPhone(user.getPhone());
        user.setIdRol(EMPLOYEE_ROLE_ID);
        userPersistencePort.saveUser(user);
    }

    @Override
    public boolean validUserOwner(Long id) {
        return userPersistencePort.validUser(id, OWNER_ROLE_ID);
    }

    @Override
    public boolean validUserEmployee(Long id) {
        return userPersistencePort.validUser(id, EMPLOYEE_ROLE_ID);
    }

    @Override
    public User getUserClient(Long id) {
        return userPersistencePort.getUserClient(id);
    }

    @Override
    public List<User> getClientAndEmployee(Long idClient, Long idEmployee) {
        return userPersistencePort.getClientAndEmployee(idClient, idEmployee);
    }
}
