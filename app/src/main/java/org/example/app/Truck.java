package org.example.app;

import java.util.ArrayList;
import java.util.Arrays;

public class Truck extends Vehicle {

    final static ArrayList<String> truckTypes = new ArrayList<String>(Arrays.asList("Extended Cab", "Crew Cab", "Single Cab"));
    private String truckType;
    private double bedLength;
    private double towingCapacity;
    private int totalAxles;

    public Truck(String make, String model, String year, String engineType, String transmission, String bodyStyle, String exteriorColor, String interiorColor, String trimPackage, int totalSeats, boolean hasBluetooth, boolean hasHeatedSeats, boolean hasRemoteStart, String truckType, double bedLength, double towingCapacity, int totalAxles) {
        super(make, model, year, engineType, transmission, bodyStyle, exteriorColor, interiorColor, trimPackage, totalSeats, hasBluetooth, hasHeatedSeats, hasRemoteStart);
        this.truckType = truckType;
        this.bedLength = bedLength;
        this.towingCapacity = towingCapacity;
        this.totalAxles = totalAxles;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public String getTruckType(){
        return truckType;
    }

    public void setBedLength(double bedLength) {
        this.bedLength = bedLength;
    }

    public double getBedLength() {
        return bedLength;
    }

    public void setTowingCapacity(double towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    public double getTowingCapacity() {
        return towingCapacity;
    }

    public void setTotalAxles(int totalAxles) {
        this.totalAxles = totalAxles;
    }

    public int getTotalAxles() {
        return totalAxles;
    }

    public ArrayList<String> getTruckTypes() {
        return truckTypes;
    }
}