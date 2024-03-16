package isp.lab6.exercise2;
import java.util.HashSet;
import java.util.Set;

public class VehicleSet {
    private Set<Vehicle> vehicles;

    public VehicleSet() {
        vehicles = new HashSet<>();
    }

    public void addVehicle(String vin, String licensePlate, String make, String model, int year) {
        Vehicle newVehicle = new Vehicle(vin, licensePlate, make, model, year);
        if (!vehicles.contains(newVehicle)) {
            vehicles.add(newVehicle);
            System.out.println("Vehicle added to the registry: " + newVehicle.toString());
        } else {
            System.out.println("Error: Vehicle with VIN " + vin + " already exists in the registry.");
        }
    }

    public void removeVehicle(String vin) {
        Vehicle vehicleToRemove = new Vehicle(vin, null, null, null, 0);
        if (vehicles.contains(vehicleToRemove)) {
            vehicles.remove(vehicleToRemove);
            System.out.println("Vehicle with VIN " + vin + " removed from the registry.");
        } else {
            System.out.println("Error: Vehicle with VIN " + vin + " does not exist in the registry.");
        }
    }

    public boolean checkVehicle(String vin) {
        Vehicle vehicleToCheck = new Vehicle(vin, null, null, null, 0);
        return vehicles.contains(vehicleToCheck);
    }

    public void displayRegistry() {
        System.out.println("Vehicle registry:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }
}
