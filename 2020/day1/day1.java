package day1;

/**
 * day1
 */

import java.io.*;
import java.util.*;

public class day1 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day1/input.txt"));
        ArrayList<Integer> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextInt());
        }

        //----------part 1 and part 2----------
        int productTwo = 0;
        int productThree = 0;
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < inputs.size(); j++) {
                int num1 = inputs.get(i);
                int num2 = inputs.get(j);
                if (num1 + num2 == 2020) {
                    productTwo = num1 * num2;
                }
                for (int k = 0; k < inputs.size(); k++) {
                    int num3 = inputs.get(k);
                    if (num1 + num2 + num3 == 2020) {
                        productThree = num1 * num2 * num3;
                    }
                }
            }
        }

        System.out.println("Part 1 Answer: " + productTwo);
        System.out.println("Part 2 Answer: " + productThree);
    }
}