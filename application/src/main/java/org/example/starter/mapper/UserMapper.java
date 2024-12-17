package org.example.starter.mapper;

import org.example.starter.domain.User;
import org.example.starter.web.controller.model.RequestUserDto;
import org.example.starter.web.controller.model.ResponseUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(RequestUserDto dto);

    ResponseUserDto toDTO(User entity);
}
