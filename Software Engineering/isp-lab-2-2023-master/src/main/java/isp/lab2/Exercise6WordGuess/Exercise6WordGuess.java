package isp.lab2.Exercise6WordGuess;

import java.util.Scanner;

public class Exercise6WordGuess {

    private static String[] words = {"reddit", "banana", "apple", "java", "github", "canteen"};
    private static String word = words[(int) (Math.random() * words.length)];
    private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (count < 7 && asterisk.contains("*")) {
            System.out.println("Guess any letter in the word");
            System.out.println(asterisk);
            String guess = sc.next();
            hang(guess);
        }
        sc.close();
    }

    public static void hang(String guess) {
        String newasterisk = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newasterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += word.charAt(i);
            } else {
                newasterisk += "*";
            }
        }

        if (asterisk.equals(newasterisk)) {
            count++;
            hangmanTries();
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(word)) {
            System.out.println("Correct! You win! The word was " + word);
        }
    }

    public static void hangmanTries() {
        switch (count) {
            case 1: {
                System.out.println("Wrong guess, try again");
                System.out.println("6 left\n");
                break;
            }
            case 2: {
                System.out.println("Wrong guess, try again");
                System.out.println("5 left\n");
                break;
            }
            case 3: {
                System.out.println("Wrong guess, try again");
                System.out.println("4 left\n");
                break;
            }
            case 4: {
                System.out.println("Wrong guess, try again");
                System.out.println("3 left\n");
                break;
            }
            case 5: {
                System.out.println("Wrong guess, try again");
                System.out.println("2 left\n");
                break;
            }
            case 6: {
                System.out.println("Wrong guess, try again");
                System.out.println("1 left\n");
                break;
            }
            case 7: {
                System.out.println("GAME OVER!");
                System.out.println("The word was " + word);
            }

        }
    }

    public static String hang1(String guess) {
        String newasterisk1 = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newasterisk1 += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk1 += word.charAt(i);
            } else {
                newasterisk1 += "*";
            }
        }

        if (asterisk.equals(newasterisk1)) {
            count++;
            hangmanTries();
        } else {
            asterisk = newasterisk1;
        }
        if (asterisk.equals(word)) {
            System.out.println("Correct! You win! The word was " + word);
        }
        return newasterisk1;
    }

}
