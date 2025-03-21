package com.nomoreft.todoapp.user.application.service;

import com.nomoreft.todoapp.user.domain.User;
import com.nomoreft.todoapp.user.domain.UserDto;
import com.nomoreft.todoapp.user.domain.UserDto2;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toEntity(UserDto userDto);

    //UserDto2 toDto2(UserDto user);
}
