package com.tda553.VehicleTypes.Cars;

import java.awt.*;

public class Volvo240 extends GenericCarWithTrim {
    public Volvo240() {
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        setVehicleWeight(1500);
        setTrimFactor(1.25);
        stopEngine();
    }
}
