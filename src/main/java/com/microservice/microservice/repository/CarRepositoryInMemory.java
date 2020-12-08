package com.microservice.microservice.repository;

import com.microservice.microservice.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryInMemory implements CarRepository {

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
    public Car getCarById(int carId) {
        for (Car car : carlist) {
            if (car.getId() == carId) return car;
        }
        return null;
    }

    @Override
    public void addCar(Car car) {
        carlist.add(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carlist;
    }

    @Override
    public Car deleteCarById(int carId) {
        int i = 0;
        for (Car car : carlist) {
            if (car.getId() == carId) {
                carlist.remove(i);
                return car;
            }
            i++;
        }
        return null;
    }

    @Override
    public void updateCar(Car car) {
        for (Car carforeach : carlist) {
            if (carforeach.getId() == car.getId()) {
                carforeach.setId(car.getId());
                carforeach.setBrand(car.getBrand());
                carforeach.setModele(car.getModele());
            }
        }
    }
}
