package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    UserEntity toEntity(User user);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    List<User> toModel(List<UserEntity> user);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    User toModel(UserEntity user);
}
