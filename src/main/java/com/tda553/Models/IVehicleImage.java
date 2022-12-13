package com.tda553.Models;

import java.awt.image.BufferedImage;

public interface IVehicleImage {
    Vehicle getVehicle();

    BufferedImage getImage();

    int[] getPosition();

    int getX();

    int getY();

    void setPosition(int x, int y);
}
