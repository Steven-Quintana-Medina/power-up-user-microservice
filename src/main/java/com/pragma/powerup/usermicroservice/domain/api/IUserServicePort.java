package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.User;

public interface IUserServicePort {
    void saveClient(User user);

    void saveOwner(User user);

    void saveEmployee(User user);

    boolean getUserOwner(Long id);

    boolean getUserEmployee(Long id);

    String getUserClient(Long id);
}
