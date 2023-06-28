package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRolRepository extends JpaRepository<RoleEntity, Long> {
    @Query("SELECT name FROM RoleEntity WHERE id = :idRol")
    String findUserOwnerById(@Param("idRol") Long idRol);
}
