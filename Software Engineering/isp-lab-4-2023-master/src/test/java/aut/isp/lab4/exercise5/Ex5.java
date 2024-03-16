package aut.isp.lab4.exercise5;
import aut.isp.lab4.exercise1.AquariumController;
import aut.isp.lab4.exercise5.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class Ex5 {
    @Test
    public void testLevelSensor(){
        LevelSensor levelSensor = new LevelSensor("Spln","model10");
        assertEquals("Sensor{model = model10, manufacturer Spln}",levelSensor.toString());

    }
    @Test
    public void testTemperatureSensor(){
        TemperatureSensor temperatureSensor = new TemperatureSensor("Spln","temp10");
        assertEquals("Sensor{model = temp10, manufacturer Spln}",temperatureSensor.toString());

    }
    @Test
    public void testAlarm(){
        Alarm alarm = new Alarm("Spln","alm10");
        assertEquals("Actuator{model = alm10, manufacturer Spln}",alarm.toString());

    }
    @Test
    public void testHeater(){
        Heater heater = new Heater("Spln","heat10");
        assertEquals("Actuator{model = heat10, manufacturer Spln}",heater.toString());

    }
}
