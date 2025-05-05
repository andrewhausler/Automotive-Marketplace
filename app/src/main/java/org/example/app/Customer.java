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
    private ArrayList<String> purchaseHistory;

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

    }

    public String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public String hashPassword(String password, String encodedSalt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = Base64.getDecoder().decode(encodedSalt);
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hash);
    }
}