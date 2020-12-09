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
        carlist.add(new Car(6, "Porsche", "Taycan"));
        carlist.add(new Car(7, "Peugeot", "e-208"));
        carlist.add(new Car(8, "Volksagen", "ID.3"));
        carlist.add(new Car(9, "BMW", "i3"));
        carlist.add(new Car(10, "Renault", "Twizy"));
        carlist.add(new Car(11, "Citroën", "AMI"));
        carlist.add(new Car(12, "Hyundai", "Kona"));
        carlist.add(new Car(13, "Honda", "e"));
        carlist.add(new Car(14, "Mercedes", "EQC"));
        carlist.add(new Car(15, "Tesla", "Roadster"));
        carlist.add(new Car(16, "Hyundai", "Ioniq 6"));
        carlist.add(new Car(17, "Volksagen", "e-Golf"));
        carlist.add(new Car(18, "Mustang", "Match-E"));
        carlist.add(new Car(19, "Audi", "Q4 e-tron"));
        carlist.add(new Car(20, "Jaguar", "i-Pace"));

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
    public void updateCar(Car partialCar, int carId) {
        for (Car carforeach : carlist) {
            if (carforeach.getId() == carId) {

                carforeach.setId(carId);
                carforeach.setBrand(partialCar.getBrand());
                carforeach.setModele(partialCar.getModele());
            }
        }
    }
}
