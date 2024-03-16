package aut.isp.lab4.exercise6;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        AquariumController controller = new AquariumController("Vegas","model nou",10.30f,new FishFeeder(), new Heater("heat10", "Lalo"), new Alarm("Lalo", "alarm10"),new pHMonitor("Spln","phmodel10"));
        System.out.println("Enter the preset ph level: ");
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        controller.setPhLevel(level);

        while(true)
        {
            System.out.println("Enter the current ph level: ");
            int phCurrent = sc.nextInt();

            controller.checkPh(phCurrent);
        }

    }
}