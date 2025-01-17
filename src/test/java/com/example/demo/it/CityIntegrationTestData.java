package com.example.demo.it;

import com.example.demo.dto.CityViewDto;

public class CityIntegrationTestData {

    public static CityViewDto getViewDto() {
        CityViewDto cityViewDto = new CityViewDto();
        cityViewDto.setName("Paris");
        return cityViewDto;
    }
}
