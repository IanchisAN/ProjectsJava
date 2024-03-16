package aut.isp.lab4.exercise6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class Ex6 {
    @Test
    public void testpHMonitor(){
        pHMonitor phMonitor = new pHMonitor("Spln","phmodel10");
        assertEquals("Sensor{model = phmodel10, manufacturer = Spln}",phMonitor.toString());

    }
}
