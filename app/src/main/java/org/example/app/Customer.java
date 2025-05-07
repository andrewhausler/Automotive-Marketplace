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
    private String passwordSalt;

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
        passwordSalt = "";
        age = 0;
        dateOfBirth = "";
        insuranceProvider = "";
        driverLicense = new DriverLicense();
    }

    public Customer(String firstName, String lastName, String phoneNumber, String email, String passwordHash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordSalt = generateSalt();
        this.passwordHash = hashPassword(passwordHash, passwordSalt);
    }

    public Customer(String firstName, String lastName, String phoneNumber, String email, String passwordHash, int age, String dateOfBirth, String insuranceProvider, DriverLicense driverLicense) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordSalt = generateSalt();
        this.passwordHash = hashPassword(passwordHash, passwordSalt);
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.insuranceProvider = insuranceProvider;
        this.driverLicense = driverLicense;
    }

    public Customer(String firstName, String lastName, String phoneNumber, String email, String passwordHash, String passwordSalt, int age, String dateOfBirth, String insuranceProvider, DriverLicense driverLicense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordSalt = passwordSalt;
        this.passwordHash = passwordHash;
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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public DriverLicense getDriversLicense() {
        return driverLicense;
    }
}