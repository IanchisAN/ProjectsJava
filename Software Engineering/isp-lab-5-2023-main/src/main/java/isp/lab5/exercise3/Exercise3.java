package isp.lab5.exercise3;

import java.util.ArrayList;



public class Exercise3 {
    public static void main(String[] args) {

        ArrayList<Sensor> sensors = new ArrayList<>();
        sensors.add(new PressureSensor("Wall","Bar",25));
        sensors.add(new TemperatureSensor("Roof","Thermo",19));
        sensors.add(new PressureSensor("Wall","Bar2",45));

        MonitoringService monitoringService = new MonitoringService(sensors);

        System.out.println(monitoringService.getAverageAllSensors());
        System.out.println(monitoringService.getAverageTemperatureSensors());


    }



}

