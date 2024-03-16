package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise5.FishFeeder;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {

        AquariumController controller = new AquariumController("Vegas","model nou",10.30f, new FishFeeder(), new Heater("heat10", "Spln"), new Alarm("Spln", "alarm10"));

        System.out.println("Enter the preset temperature: ");
        Scanner sc = new Scanner(System.in);
        int temperature = sc.nextInt();
        controller.setTemperature(temperature);

        System.out.println("Enter the preset water level: ");
        int waterLevel = sc.nextInt();
        controller.setWaterLevel(waterLevel);

        while(true){
            System.out.println("Enter the current temperature: ");
            int temperatureCurrent = sc.nextInt();

            System.out.println("Enter the current current water level: ");
            int waterLevelCurrent = sc.nextInt();

            controller.checkTemperature(temperatureCurrent);
            controller.checkWaterLevel(waterLevelCurrent);
        }
    }
}
