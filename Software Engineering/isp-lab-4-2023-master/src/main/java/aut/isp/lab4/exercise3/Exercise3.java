package aut.isp.lab4.exercise3;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {

        FishFeeder feeder1 = new FishFeeder("Stein","new model");
        AquariumController aquarium1 = new AquariumController(feeder1, "Stein","GG1");

        feeder1.fillUp();
        aquarium1.setFeedingTime(2);

        while(true){
            System.out.println("time?");

            Scanner sc=new Scanner(System.in);
            float time = sc.nextFloat();
            aquarium1.setCurrentTime(time);

            if(aquarium1.getCurrentTime() == aquarium1.getFeedingTime()){
                feeder1.feed();
            }
        }
    }
}