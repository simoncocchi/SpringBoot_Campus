package com.microservice.microservice.dao;

import com.microservice.microservice.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    public static List<Car> carlist = new ArrayList<>();

    static {
        carlist.add(new Car(1, "Tesla", "modele S"));
        carlist.add(new Car(2, "Tesla", "modele X"));
        carlist.add(new Car(3, "Lucid", "Air"));
        carlist.add(new Car(4, "Renaud", "Zoé"));
        carlist.add(new Car(5, "Audi", "e-tron"));
        carlist.add(new Car(6, "Prosche", "Taycan"));
    }

    @Override
    public List<Car> findAll() {
        return carlist;
    }

    @Override
    public Car findById(int id) {
        Car result = null;
        for (Car car : carlist) {
            if (car.getId() == id) {
                result = car;
            }
        }
        return result;
    }

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
    public Car save(Car car) {
        carlist.add(car);
        return null;
    }

    @Override
    public Car findLastInList() {
        Car lastCar = carlist.get(carlist.size() - 1);
        return lastCar;
    }
}
