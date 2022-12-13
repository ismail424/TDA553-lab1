package com.tda553.VehicleTypes.Cars;

import com.tda553.Models.Vehicle;

public class GenericCarWithTrim extends Vehicle {
    private static double trimFactor = 1;

    public static double getTrimFactor() {
        return trimFactor;
    }

    public static void setTrimFactor(double factor) {
        trimFactor = factor;
    }

    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor * getEnginePower();
    }
}
