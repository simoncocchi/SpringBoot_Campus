package com.microservice.microservice.dao;

import com.microservice.microservice.model.Car;

import java.util.List;

public interface CarDao {

    public List<Car> findAll();

    public Car findById(int id);

    public Car findByBrand(String brand);

    public Car save(Car car);

}
