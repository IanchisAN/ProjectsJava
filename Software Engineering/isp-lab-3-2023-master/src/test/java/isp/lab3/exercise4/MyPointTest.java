package isp.lab3.exercise4;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyPointTest {

    @Test
    public void testDistance() {
        MyPoint p1 = new MyPoint(1, 2, -5);
        MyPoint p2 = new MyPoint(4, 6, 7);

        double distance = p1.distance(p2);
        assertEquals(13, distance, 0.00001);
    }
}
