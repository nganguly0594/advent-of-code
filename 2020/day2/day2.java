package day2;

/**
 * day2
 */

import java.io.*;
import java.util.*;

public class day2 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day2/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        //----------part 1 and part 2----------
        int validPasswords = 0;
        int newValidPasswords = 0;
        for (int i = 0; i < inputs.size(); i++) {
            validPasswords += validate(inputs.get(i));
            newValidPasswords += newValidate(inputs.get(i));
        }

        System.out.println("Part 1 Answer: " + validPasswords);
        System.out.println("Part 2 Answer: " + newValidPasswords);
    }

    public static int validate(String password) {
        password = password.replace("-", " ");
        String[] parts = password.split(": ");
        String[] key = parts[0].split(" ");

        int letterCount = 0;
        for (int i = 0; i < parts[1].length(); i++) {
            if (parts[1].substring(i, i + 1).equals(key[2])) {
                letterCount++;
            }
        }

        if (letterCount < Integer.parseInt(key[0]) || letterCount > Integer.parseInt(key[1])) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static int newValidate(String password) {
        password = password.replace("-", " ");
        String[] parts = password.split(": ");
        String[] key = parts[0].split(" ");

        int letterCount = 0;
        for (int i = 0; i < 2; i++) {
            int index = Integer.parseInt(key[i]);
            if (parts[1].substring(index - 1, index).equals(key[2])) {
                letterCount++;
            }
        }

        if (letterCount == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }
}