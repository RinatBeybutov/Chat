package com.example.demo.mapper;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserViewDto;
import com.example.demo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "cityName", source = "city.name")
    UserViewDto mapToUserDto(UserEntity entity);

    @Mapping(target = "city", ignore = true)
    @Mapping(target = "cityId", ignore = true)
    @Mapping(target = "id", ignore = true)
    UserEntity mapToUserEntity(UserCreateDto userCreateDto);
}
