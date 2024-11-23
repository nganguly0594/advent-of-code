package day6;
/**
 * day6
 */

import java.io.*;
import java.util.*;

public class day6 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day6/input.txt"));

        ArrayList<Integer> times = new ArrayList<>();
        ArrayList<Integer> dists = new ArrayList<>();

        String[] nums = scanfile.nextLine().split(": ")[1].trim().split("\\s+");
        String[] nums2 = scanfile.nextLine().split(": ")[1].trim().split("\\s+");

        for (int i = 0; i < nums.length; i++) {
            times.add(Integer.parseInt(nums[i]));
            dists.add(Integer.parseInt(nums2[i]));
        }
        
        //----------part 1----------
        int multiply = 1;

        for (int i = 0; i < times.size(); i++) {
            int count = 0;

            int time = times.get(i);
            int dist = dists.get(i);

            for (int hold = 0; hold < time; hold++) {
                if (((time - hold) * hold) > dist) {
                    count++;
                }
            }

            multiply = (count != 0) ? multiply * count : multiply;
        }

        System.out.println("Part 1 Answer: " + multiply);

        //----------part 2----------
        long ways = 0;

        String timeString = "";
        String distString = "";

        for (int i = 0; i < times.size(); i++) {
            timeString += times.get(i);
            distString += dists.get(i);
        }

        long time = Long.parseLong(timeString);
        long dist = Long.parseLong(distString);

        for (long hold = 0; hold < time; hold++) {
            if (((time - hold) * hold) > dist) {
                ways++;
            }
        }

        System.out.println("Part 2 Answer: " + ways);
    }
}