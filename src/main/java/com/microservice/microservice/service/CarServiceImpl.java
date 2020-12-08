package com.microservice.microservice.service;

import com.microservice.microservice.model.Car;
import com.microservice.microservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public Car getCarById(int carId) {
       return this.carRepository.getCarById(carId);
    }

    @Override
    public void addCar(Car car) {
        this.carRepository.addCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return this.carRepository.getAllCars();
    }

    @Override
    public Car deleteCarById(int carId) {
        return this.carRepository.deleteCarById(carId);
    }

    @Override
    public void updateCar(Car car) {
        this.carRepository.updateCar(car);
    }
    /*
    @Override
    public Car findByBrand(String brand) {
        List<Car> filteredList = null;
        for (Car car : carlist) {
            if (car.getBrand() == brand) {
                filteredList.add(car);
            }
        }
        return (Car) filteredList;
    }

    @Override
    public Car findLastInList() {
        Car lastCar = carlist.get(carlist.size() - 1);
        return lastCar;
    } */
}
