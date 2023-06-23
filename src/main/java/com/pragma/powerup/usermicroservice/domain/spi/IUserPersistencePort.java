package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.User;

public interface IUserPersistencePort {
    void saveUser(User user);
    boolean validUser(Long id, Long rol);

    String getClient(Long id);
}
