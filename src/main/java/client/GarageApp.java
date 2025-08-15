package main.java.client;

import main.java.app.domain.Car;
import main.java.app.service.Garage;
import main.java.app.service.GarageImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class GarageApp {
    public static void main(String[] args) {
        Garage garage = new GarageImpl(new ArrayList<>(), 0, 10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Garage Menu ---");
            System.out.println("1. Add car");
            System.out.println("2. Remove car by regNumber");
            System.out.println("3. Find car by regNumber");
            System.out.println("4. Find cars by model");
            System.out.println("5. Find cars by company");
            System.out.println("6. Find cars by color");
            System.out.println("7. Find cars by engine");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка после ввода выбора

            switch (choice) {
                case 1 -> {
                    System.out.print("Reg number: ");
                    String regNumber = scanner.nextLine();
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Company: ");
                    String company = scanner.nextLine();
                    System.out.print("Engine: ");
                    double engine = scanner.nextDouble();
                    scanner.nextLine(); // очистка
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    try {
                        Car car = new Car(regNumber, model, company, engine, color);
                        garage.addCar(car);
                        System.out.println("Car added.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Reg number to remove: ");
                    String reg = scanner.nextLine();
                    try {
                        Car removed = garage.removeCar(reg);
                        System.out.println("Removed: " + removed);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Reg number to find: ");
                    String reg = scanner.nextLine();
                    try {
                        Car found = garage.findCarsByRegNumber(reg);
                        System.out.println("Found: " + found);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Model to find: ");
                    String model = scanner.nextLine();
                    Car[] cars = garage.findCarsByModel(model);
                    System.out.println("Found " + cars.length + " cars:");
                    for (int i = 0; i < cars.length; i++) {
                        Car car = cars[i];
                        System.out.println(car);
                    }
                }
                case 5 -> {
                    System.out.print("Company to find: ");
                    String company = scanner.nextLine();
                    Car[] cars = garage.findCarsByCompany(company);
                    System.out.println("Found " + cars.length + " cars:");
                    for (int i = 0; i < cars.length; i++) {
                        Car car = cars[i];
                        System.out.println(car);
                    }
                }
                case 6 -> {
                    System.out.print("Color to find: ");
                    String color = scanner.nextLine();
                    Car[] cars = garage.findCarsByColor(color);
                    System.out.println("Found " + cars.length + " cars:");
                    for (int i = 0; i < cars.length; i++) {
                        Car car = cars[i];
                        System.out.println(car);
                    }
                }
                case 7 -> {
                    System.out.print("Engine to find: ");
                    System.out.print("Min engine: ");
                    double min = scanner.nextDouble();
                    System.out.print("Max engine: ");
                    double max = scanner.nextDouble();
                    scanner.nextLine(); // очистка
                    Car[] cars = garage.findCarsByEngine(min, max);
                    System.out.println("Found " + cars.length + " cars:");
                    for (int i = 0; i < cars.length; i++) {
                        Car car = cars[i];
                        System.out.println(car);
                    }
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}