package aut.isp.lab4.exercise1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AquariumControllerTest {
    //implement minimal tests
    @Test
    public void testToString(){
        AquariumController aquarium1 = new AquariumController("Steins","M321");
        aquarium1.setCurrentTime(7);
        assertEquals("AquariumController{model = M321, manufacturer Steins, currentTime 7.0}", aquarium1.toString());
    }

    @Test
    public void testGetCurrentTime(){
        AquariumController aquarium1 = new AquariumController("Steins","M321");
        aquarium1.setCurrentTime(12);
        assertEquals(12, aquarium1.getCurrentTime(),12);
    }
}
