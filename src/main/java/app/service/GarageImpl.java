package main.java.app.service;

import main.java.app.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GarageImpl implements Garage {
    private List<Car> cars;
    private int size;
    private int capacity;

    public GarageImpl(List<Car> cars, int size, int capacity) {
        this.cars = cars;
        this.size = size;
        this.capacity = capacity;
    }

    @Override
    public boolean addCar(Car car) {
        if (cars.contains(car)) {
            return false;
        }
        cars.add(car);
        size+=1;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getRegNumber().equals(regNumber)) {
                cars.remove(i);
                size-=1;
                return car;
            }
        }
        return null;
    }

    @Override
    public Car findCarsByRegNumber(String regNumber) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        List<Car> foundedCars = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getModel().equals(model)) {
                foundedCars.add(car);
            }
        }

        return foundedCars.toArray(new Car[0]);
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        List<Car> foundedCars = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getCompany().equals(company)) {
                foundedCars.add(car);
            }
        }
        return foundedCars.toArray(new Car[0]);
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        List<Car> foundedCars = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            double engine = car.getEngine();

            if (engine >= min && engine <= max) {
                foundedCars.add(car);
            }
        }

        return foundedCars.toArray(new Car[0]);
    }

    @Override
    public Car[] findCarByColor(String color) {
        List<Car> foundedCars = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getColor().equals(color)) {
                foundedCars.add(car);
            }
        }
        return foundedCars.toArray(new Car[0]);
    }
}
