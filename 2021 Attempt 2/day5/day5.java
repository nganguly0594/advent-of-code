package day5;

/**
 * day5
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class day5 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day5/input.txt"));

        //----------part 1----------
        ArrayList<int[]> coords = new ArrayList<>();

        while(scanfile.hasNext()) {
            String line = scanfile.nextLine().replace(",", " ");
            Scanner scan = new Scanner(line);
            int[] nums = new int[4];
            nums[0] = scan.nextInt();
            nums[1] = scan.nextInt();
            scan.next();
            nums[2] = scan.nextInt();
            nums[3] = scan.nextInt();
            coords.add(nums);
        }

        int[][] map = new int[1000][1000];

        for (int i = 0; i < coords.size(); i++) {
            int x1 = coords.get(i)[0];
            int y1 = coords.get(i)[1];
            int x2 = coords.get(i)[2];
            int y2 = coords.get(i)[3];
            int tempx = 0;
            int tempy = 0;

            if (x1 == x2) {
                if (y1 > y2) {
                    tempy = y1;
                    y1 = y2;
                    y2 = tempy;
                }
                for (int row = y1; row <= y2; row++) {
                    map[row][x1]++;
                }
            }
            else if (y1 == y2) {
                if (x1 > x2) {
                    tempx = x1;
                    x1 = x2;
                    x2 = tempx;
                }
                for (int column = x1; column <= x2; column++) {
                    map[y1][column]++;
                }
            }
        }

        int count = 0;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {
                if (map[row][column] >= 2) {
                    count++;
                }
            }
        }

        System.out.println("Part 1 Answer: " + count);

        //----------part 2----------
        for (int i = 0; i < coords.size(); i++) {
            int x1 = coords.get(i)[0];
            int y1 = coords.get(i)[1];
            int x2 = coords.get(i)[2];
            int y2 = coords.get(i)[3];
            int tempx = 0;
            int tempy = 0;

            if (x1 != x2 && y1 != y2) {
                if (y1 > y2) {
                    tempy = y1;
                    y1 = y2;
                    y2 = tempy;
                    
                    tempx = x1;
                    x1 = x2;
                    x2 = tempx;
                }

                int increment = 0;

                if (x1 < x2) {
                    increment = 1;
                }
                else {
                    increment = -1;
                }
                for (int row = y1; row <= y2; row++) {
                    map[row][x1]++;
                    x1 += increment;
                }
            }
        }

        count = 0;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {
                if (map[row][column] >= 2) {
                    count++;
                }
            }
        }

        System.out.println("Part 2 Answer: " + count);
    }
}