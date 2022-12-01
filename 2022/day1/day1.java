package day1;
/**
 * day1
 */

import java.io.*;
import java.util.Scanner;

public class day1 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("input.txt"));

        //----------part 1 and part 2----------
        int largest = 0;
        int second = 0;
        int third = 0;
        while(scanfile.hasNext()) {
            String line = scanfile.nextLine();
            int sum = 0;

            while (!line.equals("") && scanfile.hasNext()) {
                sum += Integer.parseInt(line);
                line = scanfile.nextLine();
            }

            if (!scanfile.hasNext()) {
                sum += Integer.parseInt(line);
            }
            
            if (sum > largest) {
                third = second;
                second = largest;
                largest = sum;
            }
            else if (sum > second) {
                third = second;
                second = sum;
            }
            else if (sum > third) {
                third = sum;
            }
        }

        int threesum = largest + second + third;

        System.out.println("Part 1 Answer: " + largest);
        System.out.println("Part 2 Answer: " + threesum);
    }
}