package isp.lab6.exercise2;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise2Test {

    @Test
    public void testAddVehicle() {
        VehicleSet vehicleSet = new VehicleSet();
        vehicleSet.addVehicle("ABC123", "XYZ789", "Ford", "Mustang", 2022);
        assertTrue(vehicleSet.checkVehicle("ABC123"));
    }

    @Test
    public void testRemoveVehicle() {
        VehicleSet vehicleSet = new VehicleSet();
        vehicleSet.addVehicle("ABC123", "XYZ789", "Ford", "Mustang", 2022);
        vehicleSet.removeVehicle("ABC123");
        assertFalse(vehicleSet.checkVehicle("ABC123"));
    }

    @Test
    public void testCheckVehicle() {
        VehicleSet vehicleSet = new VehicleSet();
        vehicleSet.addVehicle("ABC123", "XYZ789", "Ford", "Mustang", 2022);
        assertTrue(vehicleSet.checkVehicle("ABC123"));
        assertFalse(vehicleSet.checkVehicle("DEF456"));
    }
}
