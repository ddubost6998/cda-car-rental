package fr.hb.car_rental.controller;

import fr.hb.car_rental.model.Car;
import fr.hb.car_rental.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getAllCars(Model model) {
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "car/list";
    }

    @GetMapping("/{id}")
    public String getCarById(@PathVariable Long id, Model model) {
        Car car = carService.findCarById(id);
        model.addAttribute("car", car);
        return "car/details";
    }

    @GetMapping("/add")
    public String addCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "car/add";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        Car car = carService.findCarById(id);
        model.addAttribute("car", car);
        return "car/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCar(@PathVariable Long id, @ModelAttribute Car car) {
        car.setId(id);
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }
}
