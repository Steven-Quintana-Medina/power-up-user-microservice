package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.mail = :mail")
    Optional<UserEntity> findByMail(@Param("mail") String mail);
    Optional<UserEntity> findByDniNumber(String dniNumber);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM UserEntity u WHERE u.id = :idUser AND u.idRol = :idRole")
    boolean findUserByIdAndRoleId(@Param("idUser") Long idUser, @Param("idRole") Long idRole);
    @Query("SELECT u.phone FROM UserEntity u WHERE u.id = :idUser")
    Optional<String> findPhoneById(@Param("idUser") Long idUser);

    boolean existsByMail(String mail);
}
