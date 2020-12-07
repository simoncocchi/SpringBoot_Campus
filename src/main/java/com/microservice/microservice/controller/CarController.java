package com.microservice.microservice.controller;

import com.microservice.microservice.dao.CarDao;
import com.microservice.microservice.model.Car;
import com.microservice.microservice.model.CarForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @Autowired
    private CarDao CarDao;

    @RequestMapping(value = {"/carList"}, method = RequestMethod.GET)
    public String carList(Model model) {

        model.addAttribute("cars", CarDao.findAll());

        return "carList";
    }

    @RequestMapping(value = {"/addCar"}, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

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

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }

}
