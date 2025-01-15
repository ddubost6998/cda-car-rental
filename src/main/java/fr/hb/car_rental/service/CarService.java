package fr.hb.car_rental.service;

import fr.hb.car_rental.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private static final List<Car> carList = new ArrayList<>();

    public List<Car> findAllCars() {
        return carList;
    }

    public Car findCarById(Long id) {
        for (Car car : carList) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public void saveCar(Car car) {
        if (car.getId() == null) {
            carList.add(car);
        } else {
            Car existingCar = findCarById(car.getId());
            if (existingCar != null) {
                existingCar.setRegistration(car.getRegistration());
                existingCar.setModel(car.getModel());
            }
        }
    }

    public void deleteCarById(Long id) {
        carList.removeIf(car -> car.getId().equals(id));
    }
}
