package day4;

/**
 * day4
 */

import java.io.*;
import java.util.*;

public class day4 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day4/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine().replace("-", " ").replace(",", " "));
        }

        //----------part 1 and part 2----------
        int count = 0;
        int count2 = 0;

        for (String s : inputs) {
            try (Scanner scan = new Scanner(s)) {
                int one = scan.nextInt();
                int two = scan.nextInt();
                int three = scan.nextInt();
                int four = scan.nextInt();

                if ((one <= three && two >= four) || (one >= three && two <= four)) {
                    count++;
                }
                if ((one <= three && two >= three) || (one <= four && two >= four) || (one >= three && two <= four)) {
                    count2++;
                }
            }
        }

        System.out.println("Part 1 Answer: " + count);
        System.out.println("Part 2 Answer: " + count2);
    }
}