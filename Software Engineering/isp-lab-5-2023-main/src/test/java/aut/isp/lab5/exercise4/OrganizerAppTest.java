package isp.lab5.exercise4;

import junit.framework.TestCase;

public class OrganizerAppTest extends TestCase {

    public void testTestGetName() {
        OrganizerApp organizerApp = new OrganizerApp();
        organizerApp.setName("Mircea");
        assertEquals("Mircea", organizerApp.getName());
    }


    public void testTestSetName() {
        OrganizerApp organizerApp1 = new OrganizerApp();
        organizerApp1.setName("Alin");
        assertEquals("Alin", organizerApp1.getName());
    }
}