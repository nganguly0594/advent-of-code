package day6;

/**
 * day6
 */

import java.io.*;
import java.util.Scanner;

public class day6 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day6/input.txt"));
        scanfile.useDelimiter(",");

        //----------part 1 and part 2----------
        long[] lanternfish = new long[9];

        while (scanfile.hasNext()) {
            lanternfish[scanfile.nextInt()]++;
        }

        for (int i = 0; i < 256; i++) {
            long newfish = lanternfish[0];
            lanternfish[0] = lanternfish[1];
            lanternfish[1] = lanternfish[2];
            lanternfish[2] = lanternfish[3];
            lanternfish[3] = lanternfish[4];
            lanternfish[4] = lanternfish[5];
            lanternfish[5] = lanternfish[6];
            lanternfish[6] = lanternfish[7] + newfish;
            lanternfish[7] = lanternfish[8];
            lanternfish[8] = newfish;
        }

        long sum = 0;
        for (long fish : lanternfish) {
            sum += fish;
        }

        System.out.println("Part 1 Answer: " + sum);
    }    
}