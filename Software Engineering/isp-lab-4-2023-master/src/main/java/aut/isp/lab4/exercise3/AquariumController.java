package aut.isp.lab4.exercise3;

public class AquariumController {

    //attributes

    private String manufacturer;
    private String model;
    private float currentTime;
    private FishFeeder feeder;
    private float feedingTime;

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
