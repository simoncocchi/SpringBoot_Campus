package com.microservice.microservice.controller;

import com.microservice.microservice.service.CarService;
import com.microservice.microservice.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.GET)
    @ResponseBody
    Car getCarById(@PathVariable int carId) {
        Car car = carService.getCarById(carId);
        return car;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseBody
    List<Car> getAllcars() {
        return this.carService.getAllCars();
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    void addCar(@RequestBody Car car){
        this.carService.addCar(car);
    }

    /*
    @RequestMapping(value = {"/addCar"}, method = RequestMethod.POST)
    public String saveCar(Model model, @ModelAttribute("carForm") CarForm carForm) {

        int id = CarDao.findLastInList().getId() + 1;
        String brand = carForm.getBrand();
        String modele = carForm.getModele();

        if (brand != null && brand.length() > 0
                && modele != null && modele.length() > 0) {
            Car newCar= new Car(id, brand, modele);
            CarDao.save(newCar);

            return "redirect:/carList";
        }

        return "addCar";
    }
     */

}
