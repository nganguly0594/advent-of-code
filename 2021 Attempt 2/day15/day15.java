package day15;

/**
 * day15
 */

import java.io.*;
import java.util.*;

public class day15 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day15/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        //----------part 1----------
        int[][] map = new int[inputs.size()][inputs.get(0).length()];
        
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                map[y][x] = inputs.get(y).charAt(x) - '0';
            }
        }

        System.out.println("Part 1 Answer: " + calculateRisk(map));

        //----------part 2----------
        int[][] biggerMap = new int[map.length * 5][map[0].length * 5];

        for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[0].length; x++) {
				int risk = map[y][x];
				
				for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        int newRisk = risk + r + c;
                        if (newRisk > 9) {
                            newRisk -= 9;
                        }
                        biggerMap[r * map.length + y][c * map[0].length + x] = newRisk;
                    }
				}
			}
		}

        System.out.println("Part 2 Answer: " + calculateRisk(biggerMap));
    }

    public static int calculateRisk(int[][] risks) {
        int[][] riskpaths = new int[risks.length][risks[0].length];

        for (int y = 0; y < risks.length; y++) {
            for (int x = 0; x < risks[0].length; x++) {
                riskpaths[y][x] = 100000;
            }
        }

        riskpaths[risks.length - 1][risks[0].length - 1] = 0;

        boolean change = true;
        while (change) {
            change = false;

            for (int y = 0; y < risks.length; y++) {
                for (int x = 0; x < risks[0].length; x++) {
                    int min = 1000000;
                    
                    if (y - 1 >= 0) {
                        int temp = risks[y - 1][x] + riskpaths[y - 1][x];
                        if (temp < min) {
                            min = temp;
                        }
                    }
                    if (y + 1 < risks.length) {
                        int temp = risks[y + 1][x] + riskpaths[y + 1][x];
                        if (temp < min) {
                            min = temp;
                        }
                    }
                    if (x - 1 >= 0) {
                        int temp = risks[y][x - 1] + riskpaths[y][x - 1];
                        if (temp < min) {
                            min = temp;
                        }
                    }
                    if (x + 1 < risks[0].length) {
                        int temp = risks[y][x + 1] + riskpaths[y][x + 1];
                        if (temp < min) {
                            min = temp;
                        }
                    }

                    int risk = riskpaths[y][x];
                    if (min < riskpaths[y][x]) {
                        riskpaths[y][x] = min;
                    }
                    if (risk != riskpaths[y][x]) {
                        change = true;
                    }
                }
            }
        }

        return riskpaths[0][0];
    }
}