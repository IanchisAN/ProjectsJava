package aut.isp.lab5.exercise3;


import isp.lab5.exercise3.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Exercise3Test {

    @Test
    public void testGetAverageTemperatureSensors(){

        ArrayList<Sensor> sensors = new ArrayList<>();
        sensors.add(new PressureSensor("Wall","Bar",25));
        sensors.add(new TemperatureSensor("Roof","Thermo",19));
        sensors.add(new PressureSensor("Wall","Bar2",45));
        MonitoringService monitoringService = new MonitoringService(sensors);

        double actual = monitoringService.getAverageTemperatureSensors();
        double expected = 19;
        assertEquals(expected,actual,1);
    }

    @Test
    public void testGetAverageAllSensors() {

        ArrayList<Sensor> sensors = new ArrayList<>();
        sensors.add(new PressureSensor("Wall","Bar",25));
        sensors.add(new TemperatureSensor("Roof","Thermo",20));
        sensors.add(new PressureSensor("Wall","Bar2",45));
        MonitoringService monitoringService2 = new MonitoringService(sensors);

        double actual = monitoringService2.getAverageAllSensors();
        double expected = 30;
        assertEquals(expected,actual,1);

    }
}
