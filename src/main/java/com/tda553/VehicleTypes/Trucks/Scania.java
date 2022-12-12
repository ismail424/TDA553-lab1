package com.tda553.VehicleTypes.Trucks;

import java.awt.Color;

import com.tda553.Models.TransportVehicle;

public class Scania extends TransportVehicle
{
    public Scania()
    {
        setPlatformMaxAngle(70);
        setNrDoors(2);
        setColor(Color.black);
        setEnginePower(200);
        setModelName("Scania");
        setVehicleWeight(4000);
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.1;
    }

}
