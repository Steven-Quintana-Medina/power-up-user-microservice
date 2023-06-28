package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.res;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res.UserResDto;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResMapper {
    List<UserResDto> toUserRes(List<User> user);

    UserResDto toUserRes(User user);
}
