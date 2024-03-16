package isp.lab5.exercise2;

public class SmartPhone implements Chargeable{
    private int batteryLevel;

    public SmartPhone(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel(){
        return this.batteryLevel;
    }

    public void charge(int durationInMinutes){
        this.batteryLevel += 0.3*durationInMinutes;
        if(this.batteryLevel >= 100){
            this.batteryLevel = 100;
            System.out.println("SmartPhone battery fully charged");
        }
    }
}

