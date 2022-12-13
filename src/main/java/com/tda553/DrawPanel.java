package com.tda553;

import com.tda553.Models.Vehicle;
import com.tda553.Models.VehicleImage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {


    private final List<VehicleImage> vehicleImages = new ArrayList<>();


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // Add a car to the list
    public void addVehicle(Vehicle vehicle) {
        vehicleImages.add(new VehicleImage(vehicle));
    }

    void moveit(int x, int y, Vehicle vehicle) {
        for (VehicleImage vehicleImage : vehicleImages) {
            if (vehicleImage.getVehicle() == vehicle) {
                vehicleImage.setPosition(x, y);
            }
        }
        repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (VehicleImage vehicleImage : vehicleImages) {
            g.drawImage(vehicleImage.getImage(), vehicleImage.getX(), vehicleImage.getY(), null);
        }

    }

}
