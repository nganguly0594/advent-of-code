package day1;
/**
 * day1
 */

import java.io.*;
import java.util.Scanner;

public class day1 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day1/input.txt"));

        //----------part 1----------
        int[] depth = new int[2000];

        for (int i = 0; scanfile.hasNext(); i++) {
            depth[i] = scanfile.nextInt();
        }

        int count = 0;

        for (int i = 0; i < depth.length - 1; i++) {
            if (depth[i] < depth[i + 1]) {
                count++;
            }
        }

        System.out.println("Part 1 Answer: " + count);

        //----------part 2----------
        count = 0;

        for (int i = 0; i < depth.length - 3; i++) {
            int sum1 = depth[i] + depth[i + 1] + depth[i + 2];
            int sum2 = depth[i + 1] + depth[i + 2] + depth[i + 3];
            
            if (sum1 < sum2) {
                count++;
            }
        }

        System.out.println("Part 2 Answer: " + count);
    }
}