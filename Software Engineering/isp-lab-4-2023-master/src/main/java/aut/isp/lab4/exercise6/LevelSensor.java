package aut.isp.lab4.exercise6;

public class LevelSensor extends Sensor {
    //atributes
    private float value;

    //constructor

    public LevelSensor(String manufacturer, String model) {
        super(manufacturer, model);
    }

    //methods

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
