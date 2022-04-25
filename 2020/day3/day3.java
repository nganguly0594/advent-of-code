package day3;

/**
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

        int[][] treeMap = new int[inputs.size()][inputs.get(0).length()];
        for (int y = 0; y < treeMap.length; y++) {
            for (int x = 0; x < treeMap[0].length; x++) {
                if (inputs.get(y).substring(x, x + 1).equals("#")) {
                    treeMap[y][x]++;
                }
            }
        }

        //----------part 1----------
        Point pos = new Point();
        int treesHit = 0;
        while (pos.y < treeMap.length) {
            if (pos.x >= treeMap[0].length) {
                pos.decrement(treeMap[0].length);
            }
            if (treeMap[pos.y][pos.x] > 0) {
                treesHit++;
            }
            pos.increment(2);
        }

        System.out.println("Part 1 Answer: " + treesHit);

        //----------part 2----------
        Point pos2 = new Point();
        int slope2 = 0;
        while (pos2.y < treeMap.length) {
            if (pos2.x >= treeMap[0].length) {
                pos2.decrement(treeMap[0].length);
            }
            if (treeMap[pos2.y][pos2.x] > 0) {
                slope2++;
            }
            pos2.increment(1);
        }

        Point pos3 = new Point();
        int slope3 = 0;
        while (pos3.y < treeMap.length) {
            if (pos3.x >= treeMap[0].length) {
                pos3.decrement(treeMap[0].length);
            }
            if (treeMap[pos3.y][pos3.x] > 0) {
                slope3++;
            }
            pos3.increment(3);
        }

        Point pos4 = new Point();
        int slope4 = 0;
        while (pos4.y < treeMap.length) {
            if (pos4.x >= treeMap[0].length) {
                pos4.decrement(treeMap[0].length);
            }
            if (treeMap[pos4.y][pos4.x] > 0) {
                slope4++;
            }
            pos4.increment(4);
        }

        Point pos5 = new Point();
        int slope5 = 0;
        while (pos5.y < treeMap.length) {
            if (pos5.x >= treeMap[0].length) {
                pos5.decrement(treeMap[0].length);
            }
            if (treeMap[pos5.y][pos5.x] > 0) {
                slope5++;
            }
            pos5.increment(5);
        }

        long ans = (long) treesHit * slope2 * slope3 * slope4 * slope5;

        System.out.println("Part 2 Answer: " + ans);
    }
}