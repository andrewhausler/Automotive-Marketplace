package org.example.app;

public abstract class Vehicle {

    private String make;
    private String model;
    private String year;
    private String engineType;
    private String transmission;
    private String bodyStyle;
    private String exteriorColor;
    private String interiorColor;
    private String trimPackage;
    private int totalSeats;
    private boolean hasBluetooth;
    private boolean hasHeatedSeats;
    private boolean hasRemoteStart;

    public Vehicle() {
        make = "";
        model = "";
        year = "";
        engineType = "";
        transmission = "";
        bodyStyle = "";
        exteriorColor = "";
        interiorColor = "";
        trimPackage = "";
        totalSeats = 0;
        hasBluetooth = false;
        hasHeatedSeats = false;
        hasRemoteStart = false;
    }

    public Vehicle(String make, String model, String year, String engineType, String transmission, String bodyStyle, String exteriorColor, String interiorColor, String trimPackage, int totalSeats, boolean hasBluetooth, boolean hasHeatedSeats, boolean hasRemoteStart) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.transmission = transmission;
        this.bodyStyle = bodyStyle;
        this.exteriorColor = exteriorColor;
        this.interiorColor = interiorColor;
        this.trimPackage = trimPackage;
        this.totalSeats = totalSeats;
        this.hasBluetooth = hasBluetooth;
        this.hasHeatedSeats = hasHeatedSeats;
        this.hasRemoteStart = hasRemoteStart;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setModel(String model) {
        this.model = model;
    } 

    public String getModel() {
        return model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    } 

    public void setTrimPackage(String trimPackage) {
        this.trimPackage = trimPackage;
    }

    public String getTrimPackage() {
        return trimPackage;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public boolean getHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasHeatedSeats(boolean hasHeatedSeats) {
        this.hasHeatedSeats = hasHeatedSeats;
    }

    public boolean getHasHeatedSeats() {
        return hasHeatedSeats;
    }

    public void setHasRemoteStart(boolean hasRemoteStart) {
        this.hasRemoteStart = hasRemoteStart;
    }

    public boolean getHasRemoteStart() {
        return hasRemoteStart;
    }
}