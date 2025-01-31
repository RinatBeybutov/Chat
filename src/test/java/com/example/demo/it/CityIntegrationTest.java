package com.example.demo.it;

import com.example.demo.dto.CityViewDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static com.example.demo.it.CityIntegrationTestData.getViewDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Интеграционные тесты для CityController")
@ActiveProfiles("test")
class CityIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Проверка получения списка")
    void shouldGetList() {
        var response = restTemplate
                .getForEntity("/cities", CityViewDto[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        var cities = response.getBody();
        assertNotNull(cities);
        assertEquals(3, cities.length);

        assertThat(cities[0])
                .usingRecursiveComparison()
                .isEqualTo(getViewDto());
    }
}
