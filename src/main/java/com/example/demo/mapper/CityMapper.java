package com.example.demo.mapper;

import com.example.demo.dto.CityViewDto;
import com.example.demo.entity.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityViewDto toDto(CityEntity cityEntity);
}
