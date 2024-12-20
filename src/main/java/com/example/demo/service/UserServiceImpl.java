package com.example.demo.service;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserViewDto;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final CityRepository cityRepository;

    private final UserMapper mapper;

    @Override
    public List<UserViewDto> getUsers() {
        return userRepository.findAllWithJoin()
                .stream()
                .map(mapper::mapToUserDto)
                .toList();
    }

    @Override
    public UserViewDto createUser(UserCreateDto userCreateDto) {
        UserEntity entity = mapper.mapToUserEntity(userCreateDto);

        fillCity(userCreateDto, entity);
        entity = userRepository.save(entity);

        return mapper.mapToUserDto(entity);
    }

    private void fillCity(UserCreateDto userCreateDto, UserEntity entity) {
        CityEntity city = cityRepository.findFirstByName(userCreateDto.getCityName())
                .orElseThrow(
                        ()  -> new RuntimeException("City with name = %s not found".formatted(userCreateDto.getCityName()))
                );
        entity.setCity(city);
    }
}
