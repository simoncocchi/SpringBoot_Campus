package com.microservice.microservice.controller;

import com.microservice.microservice.dao.CarDao;
import com.microservice.microservice.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarDao CarDao;

    @GetMapping(value = "cars")
    public List<Car> CarList(){
        return CarDao.findAll();
    }

    @GetMapping(value = "cars/{id}")
    public Car carById(@PathVariable int id){
        return CarDao.findById(id);
    }

}
