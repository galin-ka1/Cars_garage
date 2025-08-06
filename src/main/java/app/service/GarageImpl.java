package main.java.app.service;

import main.java.app.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GarageImpl implements Garage {
    private List<Car> cars = new ArrayList<>();
    private int size;

    @Override
    public boolean addCar(Car car) {
        return false;
    }

    @Override
    public Car removeCar(String regNumber) {
        return null;
    }

    @Override
    public Car findCarsByRegNumber(String regNumber) {
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return new Car[0];
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return new Car[0];
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return new Car[0];
    }

    @Override
    public Car[] findCarByColor(String color) {
        return new Car[0];
    }
}
