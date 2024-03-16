package aut.isp.lab4.exercise5;

public class AquariumController {

    //attributes

    private String manufacturer;
    private String model;
    private float currentTime;
    private FishFeeder feeder;
    private float feedingTime;
    private float lightOnTime;
    private float lightOffTime;
    private int temperature;
    private int waterLevel;
    private LevelSensor levelSensor;
    private Alarm alarm;
    private Heater heater;
    private float presentLevel;


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

    public AquariumController(String manufacturer, String model, float currentTime, FishFeeder feeder, Heater heater, Alarm alarm){
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feeder = feeder;
        this.heater = heater;
        this.alarm = alarm;
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

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void checkWaterLevel(int waterLevel){
        if(waterLevel < this.waterLevel)
            alarm.turnOn();
    }
    public void checkTemperature(int temperatureLevel){
        if(temperatureLevel < temperature)
            heater.turnOn();
        if(temperatureLevel == temperature)
            heater.turnOff();
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
