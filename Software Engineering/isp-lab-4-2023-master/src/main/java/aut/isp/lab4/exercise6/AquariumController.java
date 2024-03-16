package aut.isp.lab4.exercise6;

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
    private pHMonitor pHMonitor;
    private float pHLevel;


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

    public AquariumController(String manufacturer, String model, float currentTime, FishFeeder feeder, Heater heater, Alarm alarm, pHMonitor monitor){
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feeder = feeder;
        this.heater = heater;
        this.alarm = alarm;
        this.pHMonitor = monitor;
    }

    //methods

    public void setPhLevel(float phLevel) {
        this.pHLevel = phLevel;
    }

    public float getPhLevel() {
        return pHLevel;
    }

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

    public void checkPh(float currentPhLevel){
        if(currentPhLevel <= pHLevel){
            System.out.println("We can change the monitor without killing the fish!");
        }
        else
        {
            System.out.println("We cannot change the monitor without killing the fish!");
        }
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
