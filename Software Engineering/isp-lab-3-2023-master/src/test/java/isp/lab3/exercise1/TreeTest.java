package isp.lab3.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTest {

    @Test
    public void testGrow(){
        Tree t = new Tree(20);
        int actual = t.grow(10);

        int expected = 30;

        assertEquals(expected, actual);
    }
}
