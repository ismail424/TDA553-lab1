package com.tda553;

import org.junit.Test;

import com.tda553.VehicleTypes.Trucks.Scania;

public class ScaniaTest {
    Scania scania = new Scania();

    @Test(expected = IllegalStateException.class)
    public void FlatbedRuleTest() {

        // Try to raise the flatbed while is moving
        scania.startEngine();
        scania.gas(1);
        scania.move();
        scania.raisePlatform(70);
        scania.lowerPlatform(70);
        scania.brake(1);
        scania.stopEngine();
    }

    @Test(expected = IllegalArgumentException.class)
    public void  PlatformAngleTest() {
        // Raise the platform
        scania.startEngine();
        scania.raisePlatform(200);
        scania.lowerPlatform(200);
    }
}
