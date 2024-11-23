package day2;
/**
 * day2
 */

import java.io.*;
import java.util.*;

public class day2 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day2/input.txt"));

        //----------part 1 and part 2----------
        int sum = 0;
        int game = 0;
        int powerSum = 0;

        while (scanfile.hasNext()) {
            game++;
            String s = scanfile.nextLine().split(": ")[1].replace(",", ";");
            String[] parts = s.split("; ");

            Map<String, Integer> map = new HashMap<>();
            for (String part : parts) {
                String[] values = part.split(" ");
                map.put(values[1], Math.max(map.getOrDefault(values[1], 0), Integer.parseInt(values[0])));
            }

            if (map.get("red") <= 12 && map.get("green") <= 13 && map.get("blue") <= 14) {
                sum += game;
            }

            powerSum += (map.get("red") * map.get("green") * map.get("blue"));
        }

        System.out.println("Part 1 Answer: " + sum);
        System.out.println("Part 2 Answer: " + powerSum);
    }
}