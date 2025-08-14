package main.java.app.test;

import main.java.app.domain.Car;
import main.java.app.exceptions.CarAddException;
import main.java.app.exceptions.CarNotFoundException;
import main.java.app.service.Garage;
import main.java.app.service.GarageImpl;

import java.util.ArrayList;
import java.util.List;

public class GarageTest {
    public static void main(String[] args) {
        Garage garage = new GarageImpl(new ArrayList<>(), 2, 15); // емкость 2

        Car car1 = new Car("A123", "CX90", "Volvo", 3.6, "White");
        Car car2 = new Car("B456", "4x4", "NIva", 2.6, "White");
        Car car3 = new Car("C789", "CX5", "Mazda", 1.8, "Black");
// test for add
        try {
            garage.addCar(car1);
            garage.addCar(car2);
            garage.addCar(car3);
            garage.addCar(car1);

        } catch (CarAddException e) {
            System.out.println(e.getMessage());

        }
        //test for remove
        try {
            Car removed =garage.removeCar("B456");
            Car removed1=garage.removeCar("B123");

        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());

        }

        //test for find by RegNumber
        try {
            Car founded =garage.findCarsByRegNumber("A123");
            Car founded1=garage.findCarsByRegNumber("B123");

        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());

        }
        //test for find by Model
        Car[] foundedCX5 = garage.findCarsByModel("CX5");
        System.out.println("🔍 CX5 founded: " + foundedCX5.length);
        for (int i = 0; i < foundedCX5.length; i++) {
            Car car = foundedCX5[i];
            System.out.println(car.getModel());



    }


}
}
