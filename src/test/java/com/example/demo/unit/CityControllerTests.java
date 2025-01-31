
package com.example.demo.unit;

import com.example.demo.it.DBConfiguration;
import com.example.demo.repository.CityRepository;
import com.example.demo.restcontroller.CityController;
import com.example.demo.dto.CityViewDto;
import com.example.demo.service.CityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

@SpringBootTest
@DisplayName("Тестирование CityController")
@ActiveProfiles("test")
class CityControllerTests extends DBConfiguration {

    @MockitoBean
    private CityService cityService;

	@MockitoBean
	private CityRepository cityRepository;

	@Autowired
	private CityController controller;

	@BeforeEach
	void init() {
		Mockito.when(cityService.getList()).thenReturn(getAllCities());
	}

	@Test
	@DisplayName("Тест получения списка")
	void getCities() {
		ResponseEntity<List<CityViewDto>> actual = controller.getList();
		ResponseEntity<List<CityViewDto>> expected = ResponseEntity.ok(getAllCities());
		Assertions.assertEquals(expected, actual);
	}

	private List<CityViewDto> getAllCities() {
		CityViewDto city1 = new CityViewDto();
		city1.setName("Moscow");
		CityViewDto city2 = new CityViewDto();
		city2.setName("Kirov");
		return List.of(city1, city2);
	}

}

