package com.tda553.Models;

import com.tda553.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class VehicleImage implements IVehicleImage {
    private final Vehicle vehicle;
    private BufferedImage image;

    public VehicleImage(Vehicle vehicle) {
        this.vehicle = vehicle;
        // Get the name of the class
        String className = vehicle.getClass().getSimpleName();
        // Get the image from the resources folder
        try {
            this.image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + className + ".jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public int[] getPosition() {
        return this.vehicle.getPosition();
    }

    public int getX() {
        return this.vehicle.getPosition()[0];
    }

    public int getY() {
        return this.vehicle.getPosition()[1];
    }

    public void setPosition(int x, int y) {
        this.vehicle.setPosition(x, y);
    }

}
