package isp.lab5.exercise2;

public class Laptop implements Chargeable{
    private int batteryLevel;

    public Laptop(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel(){
        return this.batteryLevel;
    }

    public void charge(int durationInMinutes){
        this.batteryLevel += 0.5*durationInMinutes;
        if(this.batteryLevel >= 100){
            this.batteryLevel = 100;
            System.out.println("Laptop battery fully charged");
        }
    }

}
