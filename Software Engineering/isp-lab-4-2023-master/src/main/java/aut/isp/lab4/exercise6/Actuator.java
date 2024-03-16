package aut.isp.lab4.exercise6;

abstract class Actuator {
    //atributes

    private String manufacturer;
    private String model;

    //constructor
    public Actuator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    //methods
    public void turnOn(){
        System.out.println("The actuator is on!");
    }
    public void turnOff(){
        System.out.println("The actuator is off!");
    }
    @Override
    public String toString(){
        return "Actuator{model = " + model + ", manufacturer " + manufacturer + "}";
    }
}
