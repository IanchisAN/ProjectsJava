package isp.lab10.raceapp;

import java.util.Comparator;

public class ScoresSortingComparator  implements Comparator<Score> {

    @Override
    public int compare(Score o1, Score o2) {
        return o1.getFinish().compareTo(o2.getFinish());
    }
}
