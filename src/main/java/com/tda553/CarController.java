package com.tda553;

import javax.swing.*;

import com.tda553.Models.Vehicle;
import com.tda553.VehicleTypes.Cars.Saab95;
import com.tda553.VehicleTypes.Cars.Volvo240;
import com.tda553.VehicleTypes.Trucks.Scania;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240();
        volvo.setPosition(0, 0);
        cc.cars.add(volvo);

        // Add a saab
        Saab95 saab = new Saab95();
        saab.setPosition(0, 100);
        cc.cars.add(saab);

        // Add scania
        Scania scania = new Scania();
        scania.setPosition(0, 200);
        cc.cars.add(scania);

        
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        
        // Add all vehicles to the panel so that it can draw them
        for (Vehicle car : cc.cars) {
            cc.frame.drawPanel.addVehicleImag(car);
        }
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move(0.1);
                // Priont speed
                frame.drawPanel.moveit((int) car.getX(), (int) car.getY(), car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(double amount) {
        for (Vehicle car : cars) {
            car.gas(amount);
        }
    }

    void brake(double amount) {
        for (Vehicle car : cars) {
            car.brake(amount);
        }
    }

    void startAll() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

}
