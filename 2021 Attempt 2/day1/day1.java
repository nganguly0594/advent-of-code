package day1;
/**
 * day1 
 */

import java.io.*;
import java.util.*;

public class day1 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day1/input.txt"));

        //----------part 1----------
        ArrayList<Integer> depth = new ArrayList<>();

        while(scanfile.hasNext()) {
            depth.add(scanfile.nextInt());
        }

        int count = 0;

        for (int i = 0; i < depth.size() - 1; i++) {
            if (depth.get(i) < depth.get(i + 1)) {
                count++;
            }
        }

        System.out.println("Part 1 Answer: " + count);

        //----------part 2----------
        count = 0;

        for (int i = 0; i < depth.size() - 3; i++) {
            int sum1 = depth.get(i) + depth.get(i + 1) + depth.get(i + 2);
            int sum2 = depth.get(i + 1) + depth.get(i + 2) + depth.get(i + 3);
            
            if (sum1 < sum2) {
                count++;
            }
        }

        System.out.println("Part 2 Answer: " + count);
    }
}