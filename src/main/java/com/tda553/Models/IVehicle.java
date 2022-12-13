package com.tda553.Models;

import java.awt.*;

public interface IVehicle extends IMovable {
    int getNrDoors();

    double getEnginePower();

    double getCurrentSpeed();

    Color getColor();

    void setColor(Color clr);

    // Contract for the startEngine() method in the IVehicle interface.
    // Behavior:
    //   If the engine is already running it should not start the engine.
    //   If the engine is not running, the method should start the engine.
    void startEngine() throws IllegalStateException;

    // Contract for the stopEngine() method 
    // Input: None. & Output: None.
    // Behavior:
    //   Stops the engine but it need to meet the following requirements:
    //   - If the car is moving it should not stop the engine.
    //   - If the engine is already stopped it should not stop the engine.
    void stopEngine() throws IllegalStateException;

    // Contract for the gas() method
    // Input:
    //   amount: a double value  (0-1)
    // Behavior:
    //   Apply the gas to the vehicle by ammount.
    void gas(double amount) throws IllegalArgumentException;

    // Input:
    //   amount : a double value (0-1)
    // Behavior:
    //   Brake the vehicle by amount.
    void brake(double amount) throws IllegalArgumentException;


    double speedFactor();
}
