package org.example.app;

import java.util.ArrayList;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Customer {
    
    // Required For Making Account
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String passwordHash;
    private ArrayList<Vehicle> purchaseHistory;

    // Only Required For Purchasing A Vehicle
    private int age;
    private String dateOfBirth;
    private String insuranceProvider;
    private DriverLicense driverLicense;
    
    public Customer() {
        firstName = "";
        lastName = "";
        phoneNumber = "";
        email = "";
        passwordHash = "";
        purchaseHistory = new ArrayList<Vehicle>();
        age = 0;
        dateOfBirth = "";
        insuranceProvider = "";
        driverLicense = new DriverLicense();
    }

    public Customer(String firstName, String lastName, String phoneNumber, String email, String passwordHash, ArrayList<Vehicle> purchaseHistory) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.purchaseHistory = purchaseHistory;
    }

    public Customer(String firstName, String lastName, String phoneNumber, String email, String passwordHash, ArrayList<Vehicle> purchaseHistory, int age, String dateOfBirth, String insuranceProvider, DriverLicense driverLicense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.purchaseHistory = purchaseHistory;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.insuranceProvider = insuranceProvider;
        this.driverLicense = driverLicense;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String randomSalt = generateSalt();
        this.passwordHash = hashPassword(password, randomSalt);
    }

    public static String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String encodedSalt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = Base64.getDecoder().decode(encodedSalt);
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hash);
    }
}