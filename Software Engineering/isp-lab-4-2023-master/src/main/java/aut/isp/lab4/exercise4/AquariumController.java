package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise4.FishFeeder;

public class AquariumController {

    //attributes

    private String manufacturer;
    private String model;
    private float currentTime;
    private FishFeeder feeder;
    private float feedingTime;
    private float lightOnTime;
    private float lightOffTime;

    //constructors
    public AquariumController(String manufacturer , String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public AquariumController(FishFeeder feeder , String manufacturer , String model){
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    //methods


    public float getLightOnTime() {
        return lightOnTime;
    }

    public float getLightOffTime() {
        return lightOffTime;
    }

    public void setLightOnTime(float lightOnTime) {
        this.lightOnTime = lightOnTime;
    }

    public void setLightOffTime(float lightOffTime) {
        this.lightOffTime = lightOffTime;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public float getFeedingTime() {
        return feedingTime;
    }


    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    @Override
    public String toString(){
        return "AquariumController{model = " + model + ", manufacturer " + manufacturer + ", currentTime " + currentTime +  ", feedingTime " + feedingTime + "}";
    }
}
