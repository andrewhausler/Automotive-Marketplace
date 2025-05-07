package org.example.app;

import java.util.ArrayList;
import java.io.*;
import org.json.JSONObject;
import org.json.JSONArray;

public class DatabaseManagement {
    
    private ArrayList<Customer> accounts;
    private ArrayList<Vehicle> vehicles;
    private String accountsOnFile;
    private String vehiclesOnFile;
    
    public DatabaseManagement() {
        accountsOnFile = "app/data/database/accounts.json";
        vehiclesOnFile = "app/data/database/vehicles.json";
        accounts = new ArrayList<Customer>();
        vehicles = new ArrayList<Vehicle>();
    }

    // Retrieves the list of vehicles from the vehicles.json file and stores it into a JSONArray When Application First Runs
    public JSONArray getFileContent(String filePath) {
        StringBuilder jsonData = new StringBuilder();

        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(filePath)) {

            if(stream == null) {
                throw new FileNotFoundException("File Does Not Exist!");
            }
        
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }

            JSONArray allVehicles = new JSONArray(jsonData.toString());
            return allVehicles;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loadAccounts() {
        JSONArray allAccounts = this.getFileContent(accountsOnFile);
        for(int i=0; i<allAccounts.length(); i++) {
            JSONObject someAccount = allAccounts.getJSONObject(i);
            String firstName = someAccount.getString("firstName");
            String lastName = someAccount.getString("firstName");
            String phoneNumber = someAccount.getString("phoneNumber");
            String email = someAccount.getString("email");
            String passwordHash = someAccount.getString("passwordHash");
            String passwordSalt = someAccount.getString("passwordSalt");
            int age = someAccount.getInt("age");
            String dateOfBirth = someAccount.getString("dateOfBirth");
            String insuranceProvider = someAccount.getString("insuranceProvider");
            JSONObject driversLicense = someAccount.getJSONObject("driversLicense");
            String idNumber = driversLicense.getString("idNumber");
            String initiationDate = driversLicense.getString("initiationDate");
            String expirationDate = driversLicense.getString("expirationDate");
            String state = driversLicense.getString("state");
            DriverLicense randomLicense = new DriverLicense(firstName, lastName, idNumber, initiationDate, expirationDate, state);
            Customer loadRandomCustomer = new Customer(firstName, lastName, phoneNumber, email, passwordHash, passwordSalt, age, dateOfBirth, insuranceProvider, randomLicense);
            accounts.add(loadRandomCustomer);
        }
    }

    public void loadVehicles() {
        JSONArray allVehicles = this.getFileContent(vehiclesOnFile);
        for(int i=0; i<allVehicles.length(); i++) {
            JSONObject randomVehicle = allVehicles.getJSONObject(i);
            String make = randomVehicle.getString("make");
            String model = randomVehicle.getString("model");
            String year = randomVehicle.getString("year");
            String engineType = randomVehicle.getString("engineType");
            String transmission = randomVehicle.getString("transmission");
            String bodyStyle = randomVehicle.getString("bodyStyle");
            String exteriorColor = randomVehicle.getString("exteriorColor");
            String interiorColor = randomVehicle.getString("interiorColor");
            String trimPackage = randomVehicle.getString("trimPackage");
            int totalSeats = randomVehicle.getInt("totalSeats");
            boolean hasBluetooth = randomVehicle.getBoolean("hasBluetooth");
            boolean hasHeatedSeats = randomVehicle.getBoolean("hasHeatedSeats");
            boolean hasRemoteStart = randomVehicle.getBoolean("hasRemoteStart");
            if(randomVehicle.has("carType")) {
                String carType = randomVehicle.getString("carType");
                int totalDoors = randomVehicle.getInt("totalDoors");
                double trunkVolume = randomVehicle.getDouble("trunkVolume");
                boolean isConvertible = randomVehicle.getBoolean("isConvertible");
                boolean hasSunroof = randomVehicle.getBoolean("hasSunroof");
                Car randomCar = new Car(make, model, year, engineType, transmission, bodyStyle, exteriorColor, interiorColor, trimPackage, totalSeats, hasBluetooth, hasHeatedSeats, hasRemoteStart, carType, totalDoors, trunkVolume, isConvertible, hasSunroof);
                vehicles.add(randomCar);
            }
            else {
                String truckType = randomVehicle.getString("truckType");
                double bedLength = randomVehicle.getDouble("bedLength");
                double towingCapacity = randomVehicle.getDouble("towingCapacity");
                int totalAxles = randomVehicle.getInt("totalAxles");
                Truck randomTruck = new Truck(make, model, year, engineType, transmission, bodyStyle, exteriorColor, interiorColor, trimPackage, totalSeats, hasBluetooth, hasHeatedSeats, hasRemoteStart, truckType, bedLength, towingCapacity, totalAxles);
                vehicles.add(randomTruck);
            }
        }
    }

    public void pushAccounts() throws IOException {
        JSONArray newAccounts = new JSONArray();
        for(int i=0; i<accounts.size(); i++) {
            JSONObject newCustomer = new JSONObject();
            newCustomer.put("firstName", accounts.get(i).getFirstName());
            newCustomer.put("lastName", accounts.get(i).getLastName());
            newCustomer.put("phoneNumber", accounts.get(i).getPhoneNumber());
            newCustomer.put("email", accounts.get(i).getEmail());
            newCustomer.put("passwordSalt", accounts.get(i).getPasswordSalt());
            newCustomer.put("passwordHash", accounts.get(i).getPasswordHash());
            newCustomer.put("age", accounts.get(i).getAge());
            newCustomer.put("dateOfBirth", accounts.get(i).getDateOfBirth());
            newCustomer.put("insuranceProvider", accounts.get(i).getInsuranceProvider());
            JSONObject driversLicense = new JSONObject();
            driversLicense.put("firstName", accounts.get(i).getDriversLicense().getFirstName());
            driversLicense.put("lastName", accounts.get(i).getDriversLicense().getLastName());
            driversLicense.put("idNumber", accounts.get(i).getDriversLicense().getIdNumber());
            driversLicense.put("initiationDate", accounts.get(i).getDriversLicense().getInitiationDate());
            driversLicense.put("expirationDate", accounts.get(i).getDriversLicense().getExpirationDate());
            driversLicense.put("state", accounts.get(i).getDriversLicense().getState());
            newCustomer.put("driversLicense", driversLicense);
            newAccounts.put(newCustomer);
        }
        FileWriter file = new FileWriter(accountsOnFile);
        file.flush();
        file.write(newAccounts.toString(1));
    }

    public void pushVehicles() throws IOException {
        JSONArray newVehicles = new JSONArray();
        for(int i=0; i<vehicles.size(); i++) {
            JSONObject newVehicle = new JSONObject();
            newVehicle.put("make", vehicles.get(i).getMake());
            newVehicle.put("model", vehicles.get(i).getModel());
            newVehicle.put("year", vehicles.get(i).getYear());
            newVehicle.put("engineType", vehicles.get(i).getEngineType());
            newVehicle.put("transmission", vehicles.get(i).getTransmission());
            newVehicle.put("bodyStyle", vehicles.get(i).getBodyStyle());
            newVehicle.put("exteriorColor", vehicles.get(i).getExteriorColor());
            newVehicle.put("interiorColor", vehicles.get(i).getInteriorColor());
            newVehicle.put("trimPackage", vehicles.get(i).getTrimPackage());
            newVehicle.put("totalSeats", vehicles.get(i).getTotalSeats());
            newVehicle.put("hasBluetooth", vehicles.get(i).getHasBluetooth());
            newVehicle.put("hasHeatedSeats", vehicles.get(i).getHasHeatedSeats());
            newVehicle.put("hasRemoteStart", vehicles.get(i).getHasRemoteStart());
            if(vehicles.get(i) instanceof Car) {
                Car newCar = (Car) vehicles.get(i);
                newVehicle.put("carType", newCar.getCarType());
                newVehicle.put("totalDoors", newCar.getTotalDoors());
                newVehicle.put("trunkVolume", newCar.getTrunkVolume());
                newVehicle.put("isConvertible", newCar.getIsConvertible());
                newVehicle.put("hasSunroof", newCar.getHasSunroof());
                newVehicles.put(newVehicle);
            }
            else if(vehicles.get(i) instanceof Truck) {
                Truck newTruck = (Truck) vehicles.get(i);
                newVehicle.put("truckType", newTruck.getTruckType());
                newVehicle.put("bedLength", newTruck.getBedLength());
                newVehicle.put("towingCapacity", newTruck.getTowingCapacity());
                newVehicle.put("totalAxles", newTruck.getTotalAxles());
                newVehicles.put(newVehicle);
            }
            else {
                newVehicles.put(newVehicle);
            }
            FileWriter file = new FileWriter(vehiclesOnFile);
            file.flush();
            file.write(newVehicles.toString(1));
        }
    }

    public void addAccount(Customer newCustomer) {
        accounts.add(newCustomer);
    }

    public void addVehicle(Vehicle newVehicle) {
        vehicles.add(newVehicle);
    }

    public ArrayList<Customer> getAccounts() {
        return accounts;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

}