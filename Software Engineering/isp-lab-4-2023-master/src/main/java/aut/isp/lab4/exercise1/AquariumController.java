package aut.isp.lab4.exercise1;

public class AquariumController {

    //attributes

    private String manufacturer;
    private String model;
    private float currentTime;

    //constructors

    public AquariumController(String manufacturer , String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    //methods

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    @Override
    public String toString(){
        return "AquariumController{model = " + model + ", manufacturer " + manufacturer + ", currentTime " + currentTime + "}";
    }
}
