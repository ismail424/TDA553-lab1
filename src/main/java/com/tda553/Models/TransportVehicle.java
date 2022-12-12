package com.tda553.Models;

public abstract class TransportVehicle extends Vehicle
{
    private boolean platformActive; // Is the platform active?

    private int platformAngle = 0; // Platform angle in degrees.
    private int platformMaxAngle; // Platform maximum angle in degrees.


    // Getters and setters
    public int getPlatformAngle()
    {
        return platformAngle;
    }

    public void setPlatformAngle(int angle)
    {
        platformAngle = angle;
    }

    public int getPlatformMaxAngle()
    {
        return platformMaxAngle;
    }

    public void setPlatformMaxAngle(int angle)
    {
        platformMaxAngle = angle;
    }

    public Boolean getPlatformActive()
    {
        return platformActive;
    }

    public void setPlatformActive(Boolean active)
    {
        platformActive = active;
    }

    private boolean isPlatformLowered()
    {
        return platformAngle == 0;
    }

    /**
     * @param angle
     * Sets the platform angle to the specified value.
     * The angle of the platform cannot be lower than 0 or higher than 70.
     */
    public void raisePlatform(int angle) throws IllegalStateException
    {
        if (getPlatformAngle() == getPlatformMaxAngle())
        {
            return; // Platform is already raised
        }
        if (!getPlatformActive()) 
        {
            throw new IllegalStateException("Cannot raise platform while moving");
        }
        
        if (getPlatformAngle() + angle >= getPlatformMaxAngle()) {
            throw new IllegalArgumentException("The platform's angle cannot be raised higher!");
        }
        
        setPlatformAngle(getPlatformAngle() + angle);        
    }

    /**
     * @param angle
     * Sets the platform angle to the specified value.
     * The angle of the platform can not be lower than 0 degress.
     */ 
    public void lowerPlatform(int angle) throws IllegalStateException
    {
        if (getPlatformAngle() == 0)
        {
            return; // Platform is already lowered
        }
        if (!getPlatformActive()) 
        {
            throw new IllegalStateException("Cannot raise platform while moving");
        }

        if (getPlatformAngle() - angle >= 0)
        {
            setPlatformAngle(getPlatformAngle() - angle);
        }
        throw new IllegalArgumentException("The platform cannot be lowered any further!");
    }

    @Override
    public void startEngine()
    {
        if (getPlatformAngle() != 0)
        {
            throw new IllegalStateException("Cannot start engine while platform is raised!");
        };
        setPlatformActive(false);   
        setEningeRunning(true);
    }

    @Override
    public void stopEngine()
    {
        setCurrentSpeed(0);
        setPlatformActive(true);
    }
}
