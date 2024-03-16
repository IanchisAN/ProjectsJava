package isp.lab5.exercise3;

import java.util.ArrayList;

public class MonitoringService {
    private ArrayList<Sensor> sensors;

    public MonitoringService(ArrayList<Sensor> sensors){
        this.sensors = sensors;
    }

    public double getAverageTemperatureSensors(){
        int no = 0;
        double temperature = 0;
        for(Sensor sensor:sensors){
            if(sensor.getClass() == TemperatureSensor.class) {
                no++;
                temperature += ((TemperatureSensor) sensor).getTemperature();
            }
        }
        return temperature/no;

    }

    public double getAverageAllSensors(){
        int no = 0;
        double quantity = 0;
        for(Sensor sensor :sensors){
            quantity += sensor.getQuantity();
            no++;
        }
        return quantity/no;

    }
}

