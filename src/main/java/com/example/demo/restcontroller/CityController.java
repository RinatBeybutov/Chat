package com.example.demo.restcontroller;

import com.example.demo.config.API;
import com.example.demo.dto.CityViewDto;
import com.example.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.config.API.CITIES;

@RestController
@RequestMapping(CITIES)
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityViewDto>> getList() {
        return ResponseEntity.ok(cityService.getList());
    }
}
