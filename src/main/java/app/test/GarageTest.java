package main.java.app.test;
import main.java.app.domain.Car;
import main.java.app.exceptions.CarAddException;
import main.java.app.exceptions.CarNotFoundException;
import main.java.app.service.Garage;
import main.java.app.service.GarageImpl;
import java.util.ArrayList;

public class GarageTest {
    public static void main(String[] args) {
        Garage garage = new GarageImpl(new ArrayList<>(), 2, 15); // емкость 2

        Car car1 = new Car("A123", "CX90", "Volvo", 3.6, "White");
        Car car2 = new Car("B456", "4x4", "NIva", 2.6, "White");
        Car car3 = new Car("C789", "CX5", "Mazda", 1.8, "Black");
// test for add
        try {
            if (garage.addCar(car1)) {
                System.out.println("Car with regNumber " + car1.getRegNumber() + " added in this garage");
            }
            if (garage.addCar(car2)) {
                System.out.println("Car with regNumber " + car2.getRegNumber() + " added in this garage");
            }
            if (garage.addCar(car3)) {
                System.out.println("Car with regNumber " + car3.getRegNumber() + " added in this garage");
            }
            if (garage.addCar(car1)) {
                System.out.println("Car with regNumber " + car1.getRegNumber() + " added in this garage");
            }

        } catch (CarAddException e) {
            System.out.println(e.getMessage());

        }
        //test for remove
        try {
            Car removed = garage.removeCar("B456");
            System.out.println("Car with regNumber " + removed.getRegNumber() + "is removed");

            Car removed1 = garage.removeCar("B123"); // не существует
            System.out.println("Car with regNumber " + removed1.getRegNumber()+ "is removed");

        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //test for find by RegNumber
        try {
            Car found = garage.findCarsByRegNumber("A123");
            System.out.println("The cars with regNumber "+ found.getRegNumber() + " are found" + found.getModel());

            Car found1 = garage.findCarsByRegNumber("B123");
            System.out.println("The cars with regNumber " + found1.getRegNumber() + " are found" + found1.getModel());
        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());

        }
        //test for find by Model
        Car[] foundedCars = garage.findCarsByModel("CX5");
        System.out.println(foundedCars.length);
        for (int i = 0; i < foundedCars.length; i++) {
            Car car = foundedCars[i];
            System.out.println(car.getModel());
        }
        //test for find by Company
        Car[] foundedCars1 = garage.findCarsByCompany("Volvo");
        System.out.println(foundedCars1.length);
        for (int i = 0; i < foundedCars1.length; i++) {
            Car car = foundedCars1[i];
            System.out.println(car.getCompany());
        }
        //test for find by Color
        Car[] foundedCars2 = garage.findCarsByColor ("White");
        System.out.println(foundedCars2.length);
        for (int i = 0; i < foundedCars2.length; i++) {
            Car car = foundedCars2[i];
            System.out.println(car.getModel());
        }
        //test for find by Engine
        Car[] foundedCars3 = garage.findCarsByEngine (2.00, 4.00);
        System.out.println(foundedCars3.length);
        for (int i = 0; i < foundedCars3.length; i++) {
            Car car = foundedCars3[i];
            System.out.println(car.getModel());
        }
    }
}
