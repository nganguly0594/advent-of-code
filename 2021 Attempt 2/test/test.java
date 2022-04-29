package test;

import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        //intro
        System.out.println("Welcome to the game! You get to choose your own adventure and hope you survive!");
            wait(500);
            System.out.println("\nWhat is your name?");
            String name = scanner.nextLine();
            wait(500);
            System.out.println("\nAre you a boy or a girl?\nB) Boy\nG) Girl");
            if (scanner.nextLine().toUpperCase().equals("G")) {
                wait(500);
                System.out.println("\nNice to meet you Miss " + name + "!");
            }
            else {
                wait(500);
                System.out.println("\nNice to meet you Mr. " + name + "!");
            }
            wait(500);
            System.out.println("\nLet the adventure begin!");

        while (play) {
            wait(500);
            System.out.println("\nIt is a beautiful morning in the humble household of " + name + ".");
            for (int i = 0; i < 3; i++) {
                wait(500);
                System.out.println("\nYou wake up. What will you do?");
                wait(500);
                System.out.println("A) Get ready for the day\nB) Sleep More");
                if (scanner.nextLine().toUpperCase().equals("A")) {
                    break;
                }
                if (i != 2) {
                    System.out.println("Okay good night!");
                    for (int j = 0; j < 5; j++) {
                        wait(500);
                        System.out.print(". ");
                    }

                }
                else {
                    System.out.println("Your mom came in and yelled at you and said you were a failure. You kill yourself out of embarrassment.");
                }
            }
            
            
            System.out.println("\nYou failed. Try again? (Y or N)");
            String again = scanner.nextLine();
            if (again.equals("N")) {
                play = false;
            }
        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}