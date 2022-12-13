package com.tda553.VehicleTypes.Trucks;

import com.tda553.Models.ILoadable;
import com.tda553.Models.TransportVehicle;
import com.tda553.Models.Vehicle;
import com.tda553.VehicleLoadable;

import java.awt.*;

public class CarTransport extends TransportVehicle implements ILoadable {
    private final VehicleLoadable vehicleLoadable;

    public CarTransport() {
        this.vehicleLoadable = new VehicleLoadable(5);
        setPlatformAngle(0);
        setPlatformMaxAngle(1);
        setNrDoors(2);
        setColor(Color.black);
        setEnginePower(200);
        setModelName("CarTransport");
        setVehicleWeight(4000);
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.05;
    }

    /**
     * @param vehicle Loads a vehicle onto the platform.
     */
    public void loadVehicle(Vehicle vehicle) throws IllegalStateException {
        this.lowerPlatform(getPlatformMaxAngle());
        vehicleLoadable.loadVehicle(vehicle, getPosition());
    }

    /**
     * @param vehicle Unloads a vehicle from the platform. The vehicle must be placed close to the transport vehicle.
     */
    public Vehicle unloadVehicle(Vehicle vehicle) throws IllegalStateException {
        this.lowerPlatform(getPlatformMaxAngle());
        return vehicleLoadable.unloadVehicle(vehicle, getPosition());
    }


    /*
     * Moves the vehicle and all loaded vehicles.
     */
    @Override
    public void move() {
        // New position
        int new_pos_x = (int) Math.round(getPosition()[0] + getDirectionTable()[getDirection()][0] * getCurrentSpeed());
        int new_pos_y = (int) Math.round(getPosition()[1] + getDirectionTable()[getDirection()][1] * getCurrentSpeed());

        setPosition(new_pos_x, new_pos_y);
        for (Vehicle vehicle : vehicleLoadable.getLoadedVehicles()) {
            vehicle.setPosition(new_pos_x, new_pos_y);
        }

    }


}
