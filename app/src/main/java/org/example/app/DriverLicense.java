package org.example.app;

public class DriverLicense {

    private String firstName;
    private String lastName;
    private String idNumber;
    private String initiationDate;
    private String expirationDate;
    private String state;

    public DriverLicense() {
        firstName = "";
        lastName = "";
        idNumber = "";
        initiationDate = "";
        expirationDate = "";
        state = "";
    }

    public DriverLicense(String firstName, String lastName, String idNumber, String initiationDate, String expirationDate, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.initiationDate = initiationDate;
        this.expirationDate = expirationDate;
        this.state = state;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setInitiationDate(String initiationDate) {
        this.initiationDate = initiationDate;
    }

    public String getInitiationDate() {
        return initiationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String toString() {
        return "First name: " + firstName + " Last name: " + lastName + " ID Number: " + idNumber + " Initiation Date: " + initiationDate + " Expiration Date: " + expirationDate + " State: " + state;
    }
}