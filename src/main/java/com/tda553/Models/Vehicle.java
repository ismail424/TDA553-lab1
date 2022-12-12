package com.tda553.Models;

import java.awt.Color;

public abstract class Vehicle extends Entity implements IVehicle, ITransportable
{
    private int direction = 1;
    private int nrDoors; // Number of doors on the vehicle
    private int vehicleWeight;
    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private boolean beingTransported = false;
    private Color color; // Color of the vehicle
    private String modelName; // The vehicle model name
    private boolean isEngineRunning = false;

    private final int[][] directionTable =
    {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    public int[][] getDirectionTable()
    {
        return directionTable;
    }

    public int getDirection()
    {
        return direction;
    }

    public int getNrDoors()
    {
        return nrDoors;
    }

    public void setNrDoors(int nr)
    {
        nrDoors = nr;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String name)
    {
        modelName = name;
    }

    public double getEnginePower()
    {
        return enginePower;
    }

    public void setEnginePower(int power)
    {
        enginePower = power;
    }

    public boolean isBeingTransported()
    {
        return beingTransported;
    }

    public void setBeingTransported(boolean bt)
    {
        beingTransported = bt;
    }

    public int getVehicleWeight()
    {
        return vehicleWeight;
    }

    public void setVehicleWeight(int weight)
    {
        vehicleWeight = weight;
    }
    
    public double getCurrentSpeed()
    {
		return currentSpeed;
    }
    
    public void setCurrentSpeed(double speed)
    {
		currentSpeed = speed;
    }

    public Color getColor()
    {
        return color;
    }

    public boolean checkEngineRunning()  throws IllegalStateException
    {  
        if (!isEngineRunning)
        {
            throw new IllegalStateException("Engine is not running");
        }
        return isEngineRunning;
    }


    public void setColor(Color clr)
    {
        color = clr;
    }
    
    public void setEningeRunning(boolean running)
    {
        isEngineRunning = running;
    }

    /*
     * Start the engine
     * Throws an IllegalStateException if the engine is already running
     */
    public void startEngine() throws IllegalStateException
    {
        if (isEngineRunning)
        {
            throw new IllegalStateException("Engine is already running");
        }
        this.isEngineRunning = true;
    }
    /*
     * Stop the engine
     * Throws an IllegalStateException if the engine is already stopped or if the vehicle is moving
     */
    public void stopEngine() throws IllegalStateException
    {
        if (currentSpeed > 0)
        {
            throw new IllegalStateException("Cannot stop engine while moving");
        }

        this.isEngineRunning = false;
    }

    private void incrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed( newSpeed );

    }
    private void decrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() * (1 - amount);
        setCurrentSpeed(newSpeed);
    }

    /*
     * Accelerate the vehicle by a certain amount
     * @param amount The amount to accelerate by ( 0 - 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount) throws IllegalArgumentException, IllegalStateException
    {
        checkAmount(amount);
        checkEngineRunning();
        incrementSpeed(amount);
    }
    
    /*
     * Brake the vehicle by a certain amount
     * @param amount The amount to brake by ( 0 - 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount) throws IllegalArgumentException
    {
        checkAmount(amount);
        decrementSpeed(amount);
    }

    private void checkAmount(double amount) throws IllegalArgumentException
    {
        if (amount < 0 || amount > 1)
        {
            throw new IllegalArgumentException("Amount must be between 0 and 1");
        }
    }
  
    /*
     * Move the vehicle
    */
    public void move()
    {
        int[] direction = directionTable[getDirection()];
        int x = getX() + (int) (direction[0] * getCurrentSpeed());
        int y = getY() + (int) (direction[1] * getCurrentSpeed());
        setPosition(x, y);
    }

    public void move( double factor )
    {
        int[] direction = directionTable[getDirection()];
        int x = getX() + (int) (direction[0] * getCurrentSpeed() * factor);
        int y = getY() + (int) (direction[1] * getCurrentSpeed() * factor);
        setPosition(x, y);
    }


    public void turnLeft()
    {
        int temp_direction = (direction - 1) % 4;
        if (temp_direction < 0)
        {
            temp_direction = 3;
        }
        direction = temp_direction;
    }

    public void turnRight()
    {
        direction = (direction + 1) % 4;
    }

    public abstract double speedFactor();


}