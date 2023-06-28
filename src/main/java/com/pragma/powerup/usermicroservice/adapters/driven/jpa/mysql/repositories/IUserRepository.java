package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByMail(@Param("mail") String mail);

    Optional<UserEntity> findByDniNumber(String dniNumber);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM UserEntity u WHERE u.id = :idUser AND u.idRol = :idRole")
    boolean findUserByIdAndRoleId(@Param("idUser") Long idUser, @Param("idRole") Long idRole);

    boolean existsByMail(String mail);

    @Query("SELECT u FROM UserEntity u WHERE u.id IN (:idClient, :idEmployee)")
    List<UserEntity> findByIds(@Param("idClient") Long idClient, @Param("idEmployee") Long idEmployee);
}
