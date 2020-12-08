package com.microservice.microservice.service;

import com.microservice.microservice.model.Car;

import java.util.List;

public interface CarService {
    Car getCarById(int carId);
    void addCar(Car car);
    List<Car> getAllCars();
    Car deleteCarById(int carId);
    void updateCar(Car car);
}
