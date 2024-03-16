package isp.lab5.exercise2;

public class SmartWatch implements Chargeable{
    private int batteryLevel;
    public SmartWatch(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel(){
        return this.batteryLevel;
    }

    public void charge(int durationInMinutes){
        this.batteryLevel += 0.1*durationInMinutes;
        if(this.batteryLevel >= 100){
            this.batteryLevel = 100;
            System.out.println("SmartWatch battery fully charged");
        }
    }
}

