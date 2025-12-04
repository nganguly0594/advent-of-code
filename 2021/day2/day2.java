package day2;

/**
 * day2 
 */

import java.io.*;
import java.util.Scanner;

public class day2 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day2/input.txt"));

        //----------part 1----------
        String[] direction = new String[1000];
        int[] amount = new int[1000];

        for (int i = 0; scanfile.hasNext(); i++) {
            direction[i] = scanfile.next();
            amount[i] = scanfile.nextInt();
        }

        int distance = 0;
        int depth = 0;
        for (int i = 0; i < direction.length; i++) {
            if (direction[i].equals("forward")) {
                distance += amount[i];
            }
            else if (direction[i].equals("down")) {
                depth += amount[i];
            }
            else {
                depth -= amount[i];
            }
        }

        System.out.println("Part 1 answer: " + (distance * depth));

        //----------part 2----------
        int aim = 0;
        distance = 0;
        depth = 0;
        for (int i = 0; i < direction.length; i++) {
            if (direction[i].equals("forward")) {
                distance += amount[i];
                depth += aim * amount[i];
            }
            else if (direction[i].equals("down")) {
                aim += amount[i];
            }
            else {
                aim -= amount[i];
            }
        }

        System.out.println("Part 2 answer: " + (distance * depth));
    }
}