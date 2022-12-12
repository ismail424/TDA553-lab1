package com.tda553.VehicleTypes.Cars;

import com.tda553.Models.Vehicle;

public class GenericCarWithTurbo extends Vehicle
{
    private boolean turboOn = false;
    private double turboFactor;

    public void setTurboOn()
    {
        turboOn = true;
    }

    public void setTurboOff()
    {
        turboOn = false;
    }

    public double getTurboFactor()
    {
        return turboFactor;
    }

    public void setTurboFactor(double factor)
    {
        turboFactor = factor;
    }

    public double speedFactor()
    {
        double turbo = 1;
        if (turboOn)
            turbo = turboFactor;
        return getEnginePower() * 0.01 * turbo * getEnginePower();
    }
}
