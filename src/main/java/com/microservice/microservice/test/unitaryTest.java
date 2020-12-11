package com.microservice.microservice.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class unitaryTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void AllCars() throws Exception {
        String cars = restTemplate.getForObject("/cars", String.class);
        assertEquals(cars, "[{\"id\":1,\"brand\":\"Tesla\",\"modele\":\"modele S\"}," + "{\"id\":20,\"brand\":\"Jaguar\",\"modele\":\"i-Pace\"}]");
    }

    @Test
    public void OneCar() throws Exception {
        String cars = restTemplate.getForObject("/cars/6", String.class);
        assertEquals(cars, "[{\"id\":6,\"brand\":\"Porsche\",\"modele\":\"Taycan\"}");
    }

}
