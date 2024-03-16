package isp.lab6.exercise2;
public class Exercise2 {
    public static void main(String[] args) {
        VehicleSet vehicleSet = new VehicleSet();
        vehicleSet.addVehicle("ABC123", "XYZ789", "Ford", "Mustang", 2022);
        vehicleSet.addVehicle("DEF456", "UVW101", "Toyota", "Corolla", 2021);
        vehicleSet.displayRegistry();

        vehicleSet.addVehicle("ABC123", "YYY222", "Chevrolet", "Camaro", 2023);
        vehicleSet.displayRegistry();

        vehicleSet.removeVehicle("ABC123");
        vehicleSet.displayRegistry();

        System.out.println("Vehicle with VIN DEF456 is in the registry: " + vehicleSet.checkVehicle("DEF456"));
        System.out.println("Vehicle with VIN GHI789 is in the registry: " + vehicleSet.checkVehicle("GHI789"));
    }
}
