package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCreateDto {
    private String name;
    private String email;
    private String cityName;
}
