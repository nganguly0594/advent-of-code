package day7;

/**
 * Innerday7
 */ 

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class day7 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day7/input.txt"));
        scanfile.useDelimiter(",");

        //----------part 1----------
        ArrayList<Integer> crabs = new ArrayList<>();

        int max = 0;
        while (scanfile.hasNext()) {
            int crab = scanfile.nextInt();
            if (crab > max) {
                max = crab;
            }
            
            crabs.add(crab);
        }

        int min = 1000000000;
        for (int i = 0; i <= max; i++) {
            int fuel = 0;
            for (int j = 0; j < crabs.size(); j++) {
                fuel += Math.abs(i - crabs.get(j));
            }
            if (fuel < min) {
                min = fuel;
            }
        }

        System.out.println("Part 1 Answer: " + min);

        //----------part 2----------
        min = 1000000000;
        for (int i = 0; i <= max; i++) {
            int fuel = 0;
            for (int j = 0; j < crabs.size(); j++) {
                for (int k = Math.abs(i - crabs.get(j)); k > 0; k--) {
                    fuel += k;
                }
            }
            if (fuel < min) {
                min = fuel;
            }
        }

        System.out.println("Part 2 Answer: " + min);
    }
    
}