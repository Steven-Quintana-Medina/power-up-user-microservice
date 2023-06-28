package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.DniNumberAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
public class UserMysqlAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        if (userRepository.findByDniNumber(user.getDniNumber()).isPresent()) {
            throw new DniNumberAlreadyExistsException();
        }
        if (userRepository.existsByMail(user.getMail())) {
            throw new MailAlreadyExistsException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public boolean validUser(Long id, Long rol) {
        return userRepository.findUserByIdAndRoleId(id, rol);
    }

    @Override
    public User getUserClient(Long id) {
        return userEntityMapper.toModel(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public List<User> getClientAndEmployee(Long idClient, Long idEmployee) {
        return userEntityMapper.toModel(userRepository.findByIds(idClient, idEmployee));
    }

}
