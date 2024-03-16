package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.currentThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Race!");

        JFrame race = new JFrame("Race");
        race.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel();
        ScoreBoard sb = new ScoreBoard();


        race.pack();
        race.setVisible(true);

        CarPanel carPanel = new CarPanel();

        race.getContentPane().add(carPanel);
        race.pack();
        race.setSize(900,300);

        race.getContentPane().add(semaphorePanel,BorderLayout.WEST);
        race.getContentPane().add(sb.getScorePanel(), BorderLayout.EAST);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);

        semaphoreThread.start();


        Car car1 = new Car("Red car", carPanel,semaphoreThread );
        Car car2 = new Car("Blue car", carPanel, semaphoreThread);
        Car car3 = new Car("Green car", carPanel, semaphoreThread);
        Car car4 = new Car("Yellow car", carPanel, semaphoreThread);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        //sb.setStart();


        sb.stopTimer();
        sb.getFinish(car1.getName(),car1.retFinishTime());
        sb.getFinish(car2.getName(),car2.retFinishTime());
        sb.getFinish(car3.getName(),car3.retFinishTime());
        sb.getFinish(car4.getName(),car4.retFinishTime());

        SwingUtilities.updateComponentTreeUI(race);



    }
}
