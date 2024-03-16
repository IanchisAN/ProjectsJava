package isp.lab2.Exercise6WordGuess;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class WordGuessTest {

    @Test
    public void hang() {
        String guess = ("x");
        String expected = "Correct! You win! The word was x";
        String actual = isp.lab2.Exercise6WordGuess.Exercise6WordGuess.hang1(guess);
        assertSame(expected, actual);
    }
}
