package isp.lab3.exercise3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class VehicleTest {

    @Test
    public void testString(){
        Vehicle v1 = new Vehicle("Toyota", "Camry", 100, 'D');
        Vehicle v2 = new Vehicle("Mitsubishi", "Lancer", 70, 'B');

        System.out.println(v1.toString());
        System.out.println(v2.toString());
    }
}