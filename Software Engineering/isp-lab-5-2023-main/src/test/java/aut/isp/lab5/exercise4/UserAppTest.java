package isp.lab5.exercise4;

import junit.framework.TestCase;

public class UserAppTest extends TestCase {
    public void testGetName(){
        UserApp userApp = new UserApp();
        userApp.setName("Marian");
        assertEquals("Marian", userApp.getName());
    }
    public void testBuyTicket(){
        UserApp userApp = new UserApp();
        assertEquals(userApp.setTicketType(TicketType.EARLYBIRD), userApp.buyTicket());
    }

}
