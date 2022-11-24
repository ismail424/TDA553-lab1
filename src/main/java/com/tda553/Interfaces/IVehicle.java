package com.tda553.Interfaces;
import java.awt.Color;

public interface IVehicle extends Movable {
    int getNrDoors();
    
    double getEnginePower();
  
    double getCurrentSpeed();
 
    Color getColor();

    void setColor(Color clr);

    void startEngine();

    void stopEngine();
    
    void gas(double amount);

    void brake(double amount);

    abstract double speedFactor();
}