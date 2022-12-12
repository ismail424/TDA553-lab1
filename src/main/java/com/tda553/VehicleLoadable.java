package com.tda553;

import java.util.ArrayList;
import java.util.List;

import com.tda553.Models.Vehicle;

public class VehicleLoadable
{
    public List<Vehicle> loadedVehicles = new ArrayList<>();
    protected int maxCars;


    public VehicleLoadable(int maxCars)
    {
        this.maxCars = maxCars;
    }
    /**
     * @param vehicle
     *  Throws an IllegalStateException if the vehicle is already loaded.
     */
    public void checkBeforeLoad(Vehicle vehicle) throws IllegalStateException
    {
        // Check if the veichle is already loaded
        if (loadedVehicles.contains(vehicle))
        {
            throw new IllegalStateException("Vehicle is already loaded");
        }
    }

    public void checkBeforeUnload(Vehicle vehicle) throws IllegalStateException
    {
        // Check if the veichle is already loaded
        if (!loadedVehicles.contains(vehicle))
        {
            throw new IllegalStateException("Vehicle is not loaded");
        }
    }

    /**
     * @param vehicle
     *  Throws an IllegalStateException if the vehicle is not close enough to the loadable.
     */
    public void checkPosition(Vehicle vehicle, int[] loadablePostion) throws IllegalStateException {
        int[] vehiclePosition = vehicle.getPosition();
        // Get the position of the loadable
        if (Math.abs(vehiclePosition[0] - loadablePostion[0]) > 2 || Math.abs(vehiclePosition[1] - loadablePostion[1]) > 2)
        {
            throw new IllegalStateException("Vehicle is not close enough to the loadable");
        }
    }


    /**
     * @param vehicle
     *  Loads a vehicle onto the platform. 
     */
    public void loadVehicle(Vehicle vehicle, int[] loadablePosition) throws IllegalStateException
    {
        checkBeforeLoad(vehicle);
        checkPosition(vehicle, loadablePosition);
        loadedVehicles.add(vehicle);
    }
   
    /**
     * @param vehicle
     *  Unloads a vehicle from the platform. The vehicle must be placed close to the transport vehicle.
     */
   
    public Vehicle unloadVehicle(Vehicle vehicle, int[] loadablePosition) throws IllegalStateException
    {
        this.checkBeforeUnload(vehicle);
        this.checkPosition(vehicle, loadablePosition);
        Vehicle car = this.loadedVehicles.get(this.loadedVehicles.indexOf(vehicle));
        this.loadedVehicles.remove(vehicle);
        car.setPosition(loadablePosition[0] + 1, loadablePosition[1] + 1);
        return car;
    }
    public Vehicle[] getLoadedVehicles() {
        return loadedVehicles.toArray(new Vehicle[loadedVehicles.size()]);
    }

}