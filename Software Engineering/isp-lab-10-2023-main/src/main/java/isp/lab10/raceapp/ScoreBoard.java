package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;



public class ScoreBoard {
    private LocalTime start;
    private ArrayList<Score> scores;
    private ScorePanel scorePanel;
    private Timer tr = new Timer();

    public void stopTimer(){
        tr.setRaceFinished(false);
    }
    public ScoreBoard() {
        this.scorePanel = new ScorePanel();

        this.scorePanel.init();
        this.scores = new ArrayList<Score>();
    }

    public ScorePanel getScorePanel(){
        scorePanel.setLayout(new BoxLayout(scorePanel,BoxLayout.Y_AXIS));
        return this.scorePanel;
    }

    public void setStart(){
        start = LocalTime.now();
        tr.start();
    }

    public void getFinish(String name, LocalTime finish){
        Score temp = new Score(name, finish);
        scores.add(temp);
        Collections.sort(scores, new ScoresSortingComparator());
        scorePanel.setLabels(this.scores);
        for(Score test : scores){
            System.out.println(test.getName() + test.getFinish());
        }
        System.out.println("------------------------------");
        scorePanel.update();
    }

}

class Score{
    String name;
    LocalTime finish;

    public Score(String name,LocalTime finish) {
        this.name = name;
        this.finish = finish;
    }
    public LocalTime getFinish(){
        return this.finish;
    }

    public String getName() {
        return name;
    }
}

class Timer extends Thread{
    private long start = 0;
    private boolean raceFinished = false;

    public void setRaceFinished(boolean raceFinished) {
        this.raceFinished = raceFinished;
    }

    public void run(){
        raceFinished = true;
        while(raceFinished){
            try {
                Thread.sleep(10);
                start += 10;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("The elapsed time: " + start + " ms.");
    }
}
class ScorePanel extends JPanel{
     JLabel title = new JLabel("Scoreboard");
     ArrayList<JLabel> labels = new ArrayList<JLabel>();



    public void setLabels(ArrayList<Score> ss){
        labels.clear();
        for(Score s: ss) {
            labels.add(new JLabel(s.getName()));
        }
    }
    public ScorePanel() {
        setPreferredSize(new Dimension(300,300));
        setBackground(Color.BLUE);
    }
    public void init(){
        title.setBounds(0,0,300,20);

        super.add(title);

    }

    public void update(){
        super.removeAll();
        super.add(title);
        for(JLabel b: this.labels){
            super.add(b);
        }
    }

}
