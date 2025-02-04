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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final CityRepository cityRepository;

    private final UserMapper mapper;

    @Override
    @Transactional
    public List<UserViewDto> getUsers() {
        return userRepository.findAllWithJoin()
                .stream()
                .map(mapper::mapToUserDto)
                .toList();
    }

    @Override
    @Transactional
    public UserViewDto createUser(UserCreateDto userCreateDto) {
        var optionalUser = userRepository.findByEmail(userCreateDto.getEmail());

        if(optionalUser.isPresent()) {
            throw new RuntimeException("User with email = %s already exists".formatted(userCreateDto.getEmail()));
        }

        UserEntity entity = mapper.mapToUserEntity(userCreateDto);

        fillCity(userCreateDto, entity);
        entity = userRepository.save(entity);

        return mapper.mapToUserDto(entity);
    }

    @Override
    @Transactional
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User with email = %s not found".formatted(email)));
    }

    @Override
    @Transactional
    public void createUserByEntity(UserEntity u) throws Exception {
        var optionalUser = userRepository.findByEmail(u.getEmail());

        if(optionalUser.isPresent()) {
            throw new Exception("User with email = %s already exists".formatted(u.getEmail()));
        }

        CityEntity city = cityRepository.findAll().get(0);
        u.setCity(city);
        userRepository.save(u);
    }

    private void fillCity(UserCreateDto userCreateDto, UserEntity entity) {
        CityEntity city = cityRepository.findFirstByName(userCreateDto.getCityName())
                .orElseThrow(
                        ()  -> new RuntimeException("City with name = %s not found".formatted(userCreateDto.getCityName()))
                );
        entity.setCity(city);
    }
}
