package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserServicePort {
    void saveClient(User user);

    void saveOwner(User user);

    void saveEmployee(User user);

    boolean validUserOwner(Long id);

    boolean validUserEmployee(Long id);

    User getUserClient(Long id);

    List<User> getClientAndEmployee(Long idClient, Long idEmployee);
}
