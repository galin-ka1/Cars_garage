package main.java.app.service;

import main.java.app.domain.Car;

public interface Garage {

    boolean addCar(Car car);

    Car removeCar(String regNumber);

    Car findCarsByRegNumber(String regNumber);

    Car[] findCarsByModel(String model);

    Car[] findCarsByCompany(String company);

    Car[] findCarsByEngine(double min, double max);

    Car[] findCarByColor(String color);
}
