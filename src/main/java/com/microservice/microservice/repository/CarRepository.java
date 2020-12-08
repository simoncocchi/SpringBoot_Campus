package com.microservice.microservice.repository;

import com.microservice.microservice.model.Car;

import java.util.List;

public interface CarRepository {
    Car getCarById(int carId);
    void addCar(Car car);
    List<Car> getAllCars();
}