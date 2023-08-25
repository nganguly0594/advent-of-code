package day3;

/*
 * day3 
 */

import java.io.*;
import java.util.*;

public class day3 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day3/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        // ----------part 1----------
        int prioritySum = 0;

        for (String s : inputs) {
            String one = s.substring(0, (s.length() / 2));
            String two = s.substring(s.length() / 2);
            
            for (int i = 0; i < one.length(); i++) {
                String letter = one.substring(i, i + 1);
                if (two.contains(letter)) {
                    prioritySum += priority(letter);
                    break;
                }
            }
        }

        System.out.println("Part 1 Answer: " + prioritySum);

        // ----------part 2----------
        prioritySum = 0;

        for (int i = 0; i < inputs.size(); i += 3) {
            String one = inputs.get(i);
            String two = inputs.get(i + 1);
            String three = inputs.get(i + 2);

            for (int j = 0; j < one.length(); j++) {
                String letter = one.substring(j, j + 1);
                if (two.contains(letter) && three.contains(letter)) {
                    prioritySum += priority(letter);
                    break;
                }
            }
        }

        System.out.println("Part 2 Answer: " + prioritySum);
    }

    public static int priority(String stuff) {
        char prior = stuff.charAt(0);
        if (Character.isUpperCase(prior)) {
            return prior - 38;
        } else {
            return prior - 96;
        }
    }
}
