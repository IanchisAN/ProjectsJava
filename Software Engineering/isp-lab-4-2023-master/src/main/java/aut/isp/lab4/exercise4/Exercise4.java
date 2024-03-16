package aut.isp.lab4.exercise4;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {

        FishFeeder feeder1 = new FishFeeder("Stein","new model");
        AquariumController aquarium1 = new AquariumController(feeder1, "Stein","GG1");

        feeder1.fillUp();

        aquarium1.setFeedingTime(2.0f);
        aquarium1.setLightOnTime(1.0f);
        aquarium1.setLightOffTime(aquarium1.getLightOnTime()+7);

        while(true){
            System.out.println("time?");

            Scanner sc=new Scanner(System.in);
            float time = sc.nextFloat();
            aquarium1.setCurrentTime(time);

            if (aquarium1.getCurrentTime() >= aquarium1.getLightOnTime())
                if (aquarium1.getCurrentTime() <= aquarium1.getLightOffTime())
                { System.out.println("Lights on"); }
                else { System.out.println("Lights off"); }


            if(aquarium1.getCurrentTime() == aquarium1.getFeedingTime()){
                feeder1.feed();
            }
        }
    }
}
