package aut.isp.lab4.exercise6;
import aut.isp.lab4.exercise6.Sensor;

public class pHMonitor extends Sensor {

    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public pHMonitor(String manufacturer, String model) {
        super(manufacturer, model);
    }

}