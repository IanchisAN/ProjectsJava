package aut.isp.lab5.exercise2;

import isp.lab5.exercise2.Laptop;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2Test {

    @Test
    public void testCharge(){
        Laptop laptop = new Laptop(75);
        double expected = laptop.getBatteryLevel() + 0.5*20;
        laptop.charge(20);
        int actual = laptop.getBatteryLevel();
        assertEquals((int)expected,actual);
    }
}
