package com.example.demo.service;

import com.example.demo.dto.CityViewDto;
import com.example.demo.mapper.CityMapper;
import com.example.demo.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final CityMapper mapper;

    @Override
    public List<CityViewDto> getList() {
        return cityRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
