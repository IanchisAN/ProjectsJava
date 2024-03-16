package aut.isp.lab4.exercise3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Ex3 {

    @Test
    public void testToString(){
        AquariumController aquarium1 = new AquariumController("Stein","GG1");

        aquarium1.setCurrentTime(5.0f);
        aquarium1.setFeedingTime(2.0f);

        assertEquals("AquariumController{model = GG1, manufacturer Stein, currentTime 5.0, feedingTime 2.0}", aquarium1.toString());
    }

    @Test
    public void testGetFeedingTime(){
        AquariumController aquarium1 = new AquariumController("Stein","GG1");
        aquarium1.setFeedingTime(2.0f);

        assertEquals(2.0, aquarium1.getFeedingTime(),2.0);
    }


}
