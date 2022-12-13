package com.tda553;

import com.tda553.Models.Vehicle;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    private final Timer timer = new Timer(delay, new TimerListener());

    CarModel carModel = new CarModel();
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Add the vehicle to the view ( to be painted )
        for (Vehicle vehicle : cc.carModel.getCars()) {
            cc.frame.drawPanel.addVehicle(vehicle);
        }

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Vehicle car : carModel.getCars()) {
                car.move();
                frame.drawPanel.moveit(car.getX() ,car.getY() , car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    public void gas(int amount) {
        carModel.gas(amount);
    }

    public void brake(int amount) {
        carModel.brake(amount);
    }

    public void startAll() {
        carModel.startAll();
    }

    public void stopAll() {
        carModel.stopAll();
    }

    public void turboOn() {
        carModel.turboOn();
    }

    public void turboOff() {
        carModel.turboOff();
    }

    public void liftBed() {
        carModel.liftBed();
    }

    public void lowerBed() {
        carModel.lowerBed();
    }


}
