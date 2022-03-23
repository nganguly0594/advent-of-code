package day14;

/**
 * day14
 */

import java.io.*;
import java.util.*;

public class day14 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day14/input.txt"));
        String polymer = scanfile.nextLine();
        scanfile.nextLine();
        HashMap<String, String> insertions = new HashMap<>();
        while (scanfile.hasNext()) {
            String[] pairs = scanfile.nextLine().replace(" ", "").split("->");
            insertions.put(pairs[0], pairs[1]);
        }

        // ----------part 1 and part 2----------
        HashMap<String, Long> pairCounts = new HashMap<>();
        HashMap<String, Long> newPairCounts = new HashMap<>();
        for (String key : insertions.keySet()) {
            pairCounts.put(key, 0L);
            newPairCounts.put(key, 0L);
        }

        for (int i = 0; i < polymer.length() - 1; i++) {
            String pair = polymer.substring(i, i + 2);
            pairCounts.put(pair, pairCounts.get(pair) + 1);
        }

        for (int i = 0; i < 40; i++) {            
            for (String key : pairCounts.keySet()) {
                long counts = pairCounts.get(key);
                String firstPair = key.substring(0, 1) + insertions.get(key);
                String secondPair = insertions.get(key) + key.substring(1, 2);                
                newPairCounts.put(firstPair, newPairCounts.get(firstPair) + counts);
                newPairCounts.put(secondPair, newPairCounts.get(secondPair) + counts);
            }
            for (String key : pairCounts.keySet()) {
                pairCounts.put(key, newPairCounts.get(key));
                newPairCounts.put(key, 0L);
            }
        }

        long[] counts = new long[100];
        for (String key : pairCounts.keySet()) {
            counts[key.charAt(0)] += pairCounts.get(key);
            counts[key.charAt(1)] += pairCounts.get(key);
        }

        counts[polymer.charAt(0)]++;
        counts[polymer.charAt(polymer.length() - 1)]++;
        for (int i = 0; i < counts.length; i++) {
            counts[i] /= 2;
        }

        long max = 0L;
        long min = 10000000000000L;
        for (long i : counts) {
            if (i > max) {
                max = i;
            }
            if (i != 0 && i < min) {
                min = i;
            }
        }

        System.out.println("Part 1 Answer: " + (max - min));
    }
}