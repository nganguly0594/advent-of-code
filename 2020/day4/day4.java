package day4;

/**
 * day4
 */

import java.io.*;
import java.util.*;

public class day4 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day4/input.txt"));
        String input = scanfile.nextLine();
        while (scanfile.hasNext()) {
            input += "\n" + scanfile.nextLine() + " ";
        }
        String[] inputs = input.split("\n\n");
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = inputs[i].trim();
        }

        //----------part 1----------
        int validPassports = 0;
        for (int i = 0; i < inputs.length; i++) {
            ArrayList<String> keys = new ArrayList<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"));
            String[] info = inputs[i].split(" ");
            for (String s : info) {
                String[] parts = s.split(":");
                System.out.println(keys);
                System.out.println(parts[0]);
                keys.remove(parts[0]);
            }
            if (keys.size() == 0) {
                System.out.println("hi    " + keys);
                validPassports++;
            }
            else if (keys.size() == 1 && keys.get(0).equals("cid")) {
                System.out.println("hi    " + keys);
                validPassports++;
            }
        }

        System.out.println("Part 1 Answer: " + validPassports);
    }
}