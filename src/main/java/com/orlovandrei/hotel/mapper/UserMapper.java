package com.orlovandrei.hotel.mapper;

import com.orlovandrei.hotel.entity.user.User;
import com.orlovandrei.hotel.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
    @Mapping(source = "email", target = "email")
    UserDto toDto(User user);

    @Mapping(source = "email", target = "email")
    User toEntity(UserDto dto);
}