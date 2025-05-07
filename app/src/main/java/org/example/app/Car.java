package org.example.app;

import java.util.ArrayList;
import java.util.Arrays;

public class Car extends Vehicle {

    private String carType;
    private int totalDoors;
    private double trunkVolume;
    private boolean isConvertible;
    private boolean hasSunroof;
    
    public Car(String make, String model, String year, String engineType, String transmission, String bodyStyle, String exteriorColor, String interiorColor, String trimPackage, int totalSeats, boolean hasBluetooth, boolean hasHeatedSeats, boolean hasRemoteStart, String carType, int totalDoors, double trunkVolume, boolean isConvertible, boolean hasSunroof) {
        super(make, model, year, engineType, transmission, bodyStyle, exteriorColor, interiorColor, trimPackage, totalSeats, hasBluetooth, hasHeatedSeats, hasRemoteStart);
        this.carType = carType;
        this.totalDoors = totalDoors;
        this.trunkVolume = trunkVolume;
        this.isConvertible = isConvertible;
        this.hasSunroof = hasSunroof;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarType() {
        return carType;
    }

    public void setTotalDoors(int totalDoors) {
        this.totalDoors = totalDoors;
    }

    public int getTotalDoors() {
        return totalDoors;
    }

    public void setTrunkVolume(double trunkVolume) {
        this.trunkVolume = trunkVolume;
    }

    public double getTrunkVolume() {
        return trunkVolume;
    }

    public void setIsConvertible(boolean isConvertible) {
        this.isConvertible = isConvertible;
    }

    public boolean getIsConvertible() {
        return isConvertible;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public boolean getHasSunroof() {
        return hasSunroof;
    }
}