package com.microservice.microservice.test;

import com.microservice.microservice.model.Car;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class unitaryTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    public void AllCars() throws Exception {
        String cars = restTemplate.getForObject("/cars", String.class);
        assertEquals(cars, "[{\"id\":1,\"brand\":\"Tesla\",\"modele\":\"modele S\"},{\"id\":2,\"brand\":\"Tesla\",\"modele\":\"modele X\"},{\"id\":3,\"brand\":\"Lucid\",\"modele\":\"Air\"},{\"id\":4,\"brand\":\"Renaud\",\"modele\":\"Zoé\"},{\"id\":5,\"brand\":\"Audi\",\"modele\":\"e-tron\"},{\"id\":6,\"brand\":\"Porsche\",\"modele\":\"Taycan\"},{\"id\":7,\"brand\":\"Peugeot\",\"modele\":\"e-208\"},{\"id\":8,\"brand\":\"Volksagen\",\"modele\":\"ID.3\"},{\"id\":9,\"brand\":\"BMW\",\"modele\":\"i3\"},{\"id\":10,\"brand\":\"Renault\",\"modele\":\"Twizy\"},{\"id\":11,\"brand\":\"Citroën\",\"modele\":\"AMI\"},{\"id\":12,\"brand\":\"Hyundai\",\"modele\":\"Kona\"},{\"id\":13,\"brand\":\"Honda\",\"modele\":\"e\"},{\"id\":14,\"brand\":\"Mercedes\",\"modele\":\"EQC\"},{\"id\":15,\"brand\":\"Tesla\",\"modele\":\"Roadster\"},{\"id\":16,\"brand\":\"Hyundai\",\"modele\":\"Ioniq 6\"},{\"id\":17,\"brand\":\"Volksagen\",\"modele\":\"e-Golf\"},{\"id\":18,\"brand\":\"Mustang\",\"modele\":\"Match-E\"},{\"id\":19,\"brand\":\"Audi\",\"modele\":\"Q4 e-tron\"},{\"id\":20,\"brand\":\"Jaguar\",\"modele\":\"i-Pace\"}]");
    }

    @Test
    @Order(2)
    public void OneCar() throws Exception {
        String cars = restTemplate.getForObject("/cars/6", String.class);
        assertEquals(cars, "{\"id\":6,\"brand\":\"Porsche\",\"modele\":\"Taycan\"}");
    }

    @Test
    @Order(3)
    public void CreateCar() throws Exception {
        Car car = new Car( 21, "Audi", "A3");
        restTemplate.postForObject("/cars", car, String.class);
        String cars = restTemplate.getForObject("/cars/21", String.class);
        assertEquals(cars, "{\"id\":21,\"brand\":\"Audi\",\"modele\":\"A3\"}");
    }

    @Test
    @Order(4)
    public void UpdateCar() throws Exception {
        Car car = new Car(21, "Audi", "A4 Break");
        restTemplate.put("/cars/21", car, String.class);
        String cars = restTemplate.getForObject("/cars/21", String.class);
        assertEquals(cars, "{\"id\":21,\"brand\":\"Audi\",\"modele\":\"A4 Break\"}");

    }

    @Test
    @Order(5)
    public void DeleteCar() throws Exception {
        restTemplate.delete("/cars/21", String.class);
        String cars = restTemplate.getForObject("/cars", String.class);
        assertEquals(cars, "[{\"id\":1,\"brand\":\"Tesla\",\"modele\":\"modele S\"},{\"id\":2,\"brand\":\"Tesla\",\"modele\":\"modele X\"},{\"id\":3,\"brand\":\"Lucid\",\"modele\":\"Air\"},{\"id\":4,\"brand\":\"Renaud\",\"modele\":\"Zoé\"},{\"id\":5,\"brand\":\"Audi\",\"modele\":\"e-tron\"},{\"id\":6,\"brand\":\"Porsche\",\"modele\":\"Taycan\"},{\"id\":7,\"brand\":\"Peugeot\",\"modele\":\"e-208\"},{\"id\":8,\"brand\":\"Volksagen\",\"modele\":\"ID.3\"},{\"id\":9,\"brand\":\"BMW\",\"modele\":\"i3\"},{\"id\":10,\"brand\":\"Renault\",\"modele\":\"Twizy\"},{\"id\":11,\"brand\":\"Citroën\",\"modele\":\"AMI\"},{\"id\":12,\"brand\":\"Hyundai\",\"modele\":\"Kona\"},{\"id\":13,\"brand\":\"Honda\",\"modele\":\"e\"},{\"id\":14,\"brand\":\"Mercedes\",\"modele\":\"EQC\"},{\"id\":15,\"brand\":\"Tesla\",\"modele\":\"Roadster\"},{\"id\":16,\"brand\":\"Hyundai\",\"modele\":\"Ioniq 6\"},{\"id\":17,\"brand\":\"Volksagen\",\"modele\":\"e-Golf\"},{\"id\":18,\"brand\":\"Mustang\",\"modele\":\"Match-E\"},{\"id\":19,\"brand\":\"Audi\",\"modele\":\"Q4 e-tron\"},{\"id\":20,\"brand\":\"Jaguar\",\"modele\":\"i-Pace\"}]");
    }

}
