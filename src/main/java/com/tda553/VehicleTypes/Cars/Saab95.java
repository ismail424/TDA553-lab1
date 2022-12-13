package com.tda553.VehicleTypes.Cars;

import java.awt.*;

public class Saab95 extends GenericCarWithTurbo {
    public Saab95() {
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        setModelName("Saab95");
        setVehicleWeight(1500);
        setTurboFactor(1.3);
        stopEngine();
    }
}
