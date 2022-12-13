package com.tda553.Models;

import com.tda553.VehicleLoadable;

public class RepairShop extends Entity implements ILoadable {
    private final VehicleLoadable vehicleLoadable;

    public RepairShop(int x, int y) {
        this.setPosition(x, y);
        this.vehicleLoadable = new VehicleLoadable(1);
    }

    /**
     * @param vehicle Loads a vehicle into the repair shop.
     */
    public void loadVehicle(Vehicle vehicle) throws IllegalStateException {
        this.vehicleLoadable.loadVehicle(vehicle, this.getPosition());
    }

    /**
     * @param vehicle Unloads a vehicle from the repair shop. The vehicle must be placed close to the repair shop.
     */
    public Vehicle unloadVehicle(Vehicle vehicle) throws IllegalStateException {
        return this.vehicleLoadable.unloadVehicle(vehicle, this.getPosition());
    }
}
