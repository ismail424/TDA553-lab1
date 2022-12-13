package com.tda553;
import org.junit.Before;
import org.junit.Test;

import com.tda553.VehicleTypes.Cars.Volvo240;
import com.tda553.VehicleTypes.Trucks.CarTransport;

public class CarTransportTest {

    CarTransport euro_truck = new CarTransport();

    @Test(expected = IllegalArgumentException.class)
    public void PlatformAngleTest() {
        euro_truck.startEngine();
        // Raise the platform more that the maximum angle
        euro_truck.raisePlatform(2);
        euro_truck.lowerPlatform(-2);
    }

    // Expected IllegalArgumentException and IllegalStateException
    @Test(expected = IllegalStateException.class)
    public void CanChangeAngleIfOnlyStationary() {
        // Raise the platform more that the maximum angle
        euro_truck.startEngine();
        euro_truck.gas(1);
        euro_truck.move();
        euro_truck.raisePlatform(1);
        euro_truck.lowerPlatform(1);
        euro_truck.brake(1);
        euro_truck.stopEngine();
    }


    private Volvo240 volvo = new Volvo240();

    @Test
    public void loadVehicleTest() {
        // Raise the platform more that the maximum angle
        euro_truck.startEngine();
        euro_truck.brake(1);
        if (euro_truck.getPlatformAngle() == 0) {
            euro_truck.loadVehicle(this.volvo);
        }
        else{
            euro_truck.lowerPlatform(1);
            euro_truck.loadVehicle(this.volvo);
        }
        
        euro_truck.startEngine();
        euro_truck.gas(1);
        euro_truck.move();
        try {
            euro_truck.loadVehicle(volvo);
            AssertionError e = new AssertionError("Should not be able to load a vehicle while moving");
            throw e;
        } 
        catch (IllegalStateException e) 
        {
            // Expected
            euro_truck.brake(1);
            euro_truck.stopEngine();             
        }
    }    

    @Test
    public void unloadVehicleTest(){
        this.loadVehicleTest();
        euro_truck.startEngine();
        euro_truck.unloadVehicle(this.volvo);
    }

    @Test(expected = IllegalStateException.class)
    public void loadDuplicateTest(){
        this.loadVehicleTest();
        euro_truck.loadVehicle(this.volvo);
    }
}
