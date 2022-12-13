package com.tda553;

import com.tda553.Models.Vehicle;
import com.tda553.VehicleTypes.Cars.Saab95;
import com.tda553.VehicleTypes.Cars.Volvo240;
import com.tda553.VehicleTypes.Trucks.Scania;
import com.tda553.VehicleTypes.Cars.GenericCarWithTurbo;
import java.util.ArrayList;

public class CarModel {

    ArrayList<Vehicle> cars = new ArrayList<>();

    public CarModel() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();

        volvo.setPosition(0, 0);
        saab.setPosition(0, 100);
        scania.setPosition(0, 200);

        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);
    }

    public ArrayList<Vehicle> getCars() {
        return cars;
    }

    // Calls the gas method for each car once
    void gas(double amount) {
        for (Vehicle car : cars) {
            car.gas(amount);
            System.out.println("Applying gas to " + car.getModelName() + " with amount " + amount);
        }
    }

    void brake(double amount) {
        for (Vehicle car : cars) {
            car.brake(amount);
            System.out.println("Braking " + car.getModelName() + " with " + amount);
        }
    }

    void startAll() {
        for (Vehicle car : cars) {
            car.startEngine();
            System.out.println("Starting engine for " + car.getModelName());
        }
    }

    void stopAll() {
        for (Vehicle car : cars) {
            car.stopEngine();
            System.out.println("Stopping engine for " + car.getModelName());
        }
    }

    void turboOn() {
        for (Vehicle car : cars) {
            if (car instanceof GenericCarWithTurbo) {
                ((GenericCarWithTurbo) car).setTurboOn();
                System.out.println("Turbo on");

            }
        }
    }

    void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof GenericCarWithTurbo) {
                ((GenericCarWithTurbo) car).setTurboOff();
                System.out.println("Turbo off");
            }
        }
    }

    void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                if (((Scania) car).getPlatformAngle() < 70) {
                    ((Scania) car).raisePlatform(((Scania) car).getPlatformMaxAngle()  );
                    System.out.println("Successfully raised platform");
                }
                else {
                    System.out.println("Platform angle is already at max");
                }
            }
        }
    }

    void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                if (((Scania) car).getPlatformAngle() > 0) {
                    ((Scania) car).lowerPlatform(((Scania) car).getPlatformMaxAngle());
                    System.out.println("Successfully lowered bed");
                }
                else {
                    System.out.println("Platform angle is already at 0");
                }

            }
        }
    }

}

