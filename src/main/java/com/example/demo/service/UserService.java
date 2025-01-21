package com.example.demo.service;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserViewDto;
import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserViewDto> getUsers();

    UserViewDto createUser(UserCreateDto userViewDto);

    UserEntity getUserByEmail(String email);

    void createUserByEntity(UserEntity u);
}
