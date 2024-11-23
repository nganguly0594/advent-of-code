package day1;
/**
 * day1 
 */

import java.io.*;
import java.util.*;

public class day1 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day1/input.txt"));
        Scanner scanfile2 = new Scanner(new File("day1/input.txt"));

        //----------part 1----------
        int sum = 0;

        while (scanfile.hasNext()) {
            char[] array = scanfile.nextLine().toCharArray();

            String add = "";

            for (int i = 0; i < array.length; i++) {
                if (Character.isDigit(array[i])) {
                    add += array[i];
                    break;
                }
            }

            for (int i = array.length - 1; i >= 0; i--) {
                if (Character.isDigit(array[i])) {
                    add += array[i];
                    break;
                }
            }

            sum += Integer.parseInt(add);
        }

        System.out.println("Part 1 Answer: " + sum);

        //----------part 2----------
        int sum2 = 0;

        while (scanfile2.hasNext()) {
            String s = scanfile2.nextLine().replace("zero", "z0o").replace("one", "o1e")
                                           .replace("two", "t2o").replace("three", "t3e")
                                           .replace("four", "f4r").replace("five", "f5e")
                                           .replace("six", "s6x").replace("seven", "s7n")
                                           .replace("eight", "e8t").replace("nine", "n9e");
            
        char[] array = s.toCharArray();

            String add = "";

            for (int i = 0; i < array.length; i++) {
                if (Character.isDigit(array[i])) {
                    add += array[i];
                    break;
                }
            }

            for (int i = array.length - 1; i >= 0; i--) {
                if (Character.isDigit(array[i])) {
                    add += array[i];
                    break;
                }
            }

            sum2 += Integer.parseInt(add);
        }

        System.out.println("Part 2 Answer: " + sum2);
    }
}