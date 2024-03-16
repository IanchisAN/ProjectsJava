package aut.isp.lab4.exercise5;

abstract class Sensor {
    //atributes
    private String manufacturer;
    private String model;

    //constructor

    public Sensor(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    //methods


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString(){
        return "Sensor{model = " + model + ", manufacturer " + manufacturer + "}";
    }
}
