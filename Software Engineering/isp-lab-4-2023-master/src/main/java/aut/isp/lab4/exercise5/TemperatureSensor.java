package aut.isp.lab4.exercise5;

public class TemperatureSensor extends Sensor{

    // atributes

    private int value;

    public TemperatureSensor(String manufacturer, String model) {
        super(manufacturer, model);
    }

    //methods

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

