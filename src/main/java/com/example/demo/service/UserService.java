package com.example.demo.service;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserViewDto;

import java.util.List;

public interface UserService {
    List<UserViewDto> getUsers();

    UserViewDto createUser(UserCreateDto userViewDto);
}
