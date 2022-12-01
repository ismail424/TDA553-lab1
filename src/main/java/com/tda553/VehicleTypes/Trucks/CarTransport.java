package com.tda553.VehicleTypes.Trucks;
import java.awt.Color;
import com.tda553.Interfaces.ILoadable;
import com.tda553.Models.TransportVehicle;
import com.tda553.Models.Vehicle;
import com.tda553.Models.TransportVehicle;

public class CarTransport extends TransportVehicle implements ILoadable
{
    public CarTransport()
    {
        this.platformAngle = 0;
        this.platformMaxAngle = 1;
        nrDoors = 2;
        color = Color.black;
        enginePower = 200;
        modelName = "CarTransport";
        vehicleWeight = 4000;
        stopEngine();
    }
        
    /**
     * @param vehicle
     *  Loads a vehicle onto the platform.
     */
    public void loadVehicle(Vehicle vehicle)
    {
        if (!this.isPlatformActive())
        {   
            throw new IllegalStateException("Cannot load vehicle while moving");
        }
        if (this.getPlatformAngle() != 0)
        {
            throw new IllegalStateException("Platform must be down to load vehicles!");
        }
        int[] vehiclePosition = vehicle.getPosition();
        int[] thisPosition = this.getPosition();
        // Close enough to the platform
        if (Math.abs(vehiclePosition[0] - thisPosition[0]) > 2 || Math.abs(vehiclePosition[1] - thisPosition[1]) > 2)
        {
            throw new IllegalStateException("Vehicle is not close enough to the platform");
        }
        loadedVehicles.add(vehicle);
    }

    /**
     * @param vehicle
     *  Unloads a vehicle from the platform. The vehicle must be placed close to the transport vehicle.
     */
    public Vehicle unloadVehicle(Vehicle vehicle)
    {
        if (this.getPlatformAngle() != 0)
        {
            throw new IllegalStateException("Platform must be down to load vehicles!");
        }
        Vehicle car = loadedVehicles.get(loadedVehicles.indexOf(vehicle));
        loadedVehicles.remove(vehicle);
        int[] transportPos = this.getPosition();
        car.setPosition(transportPos[0] + 1, transportPos[1] + 1);
        return car;
    }
    
    public int getPlatformAngle()
    {
        return platformAngle;
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.05;
    }

}
