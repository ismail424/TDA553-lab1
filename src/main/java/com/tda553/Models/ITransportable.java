package com.tda553.Models;

public interface ITransportable {
    int getVehicleWeight();

    boolean isBeingTransported();

    void setBeingTransported(boolean bt);
}
