package isp.lab6.exercise3;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
public class Exercise3Test {
    @Test
    public void addSessionTest() {
        OnlineStore onlineStore = new OnlineStore();
        String username = "test_user";

        onlineStore.addSession(username);

        Assert.assertTrue(onlineStore.sessions.containsKey(username));
        Assert.assertEquals(username, onlineStore.sessions.get(username).getUsername());
    }
    @Test
    public void testLoginSuccess() {
        OnlineStore onlineStore = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(onlineStore);
        String username = "test_user";
        String password = "test_password";
        loginSystem.register(username, password);

        boolean result = loginSystem.login(username, password);

        assertTrue(result);
    }
    @Test
    public void testLoginFailure() {
        OnlineStore onlineStore = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(onlineStore);
        String username = "test_user";
        String password = "test_password";
        loginSystem.register(username, password);

        boolean result = loginSystem.login(username, "wrong_password");

        assertFalse(result);
    }

    @Test
    public void testEquals() {
        Product product1 = new Product("Bread", 10);
        Product product2 = new Product("Bread", 10);
        Product product3 = new Product("Butter", 15);

        assertEquals(product1, product2);

        assertNotEquals(product1, product3);

        assertNotEquals(product1, new Product("Bread", 5));
    }
}