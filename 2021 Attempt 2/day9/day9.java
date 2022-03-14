package day9;

/**
 * day9
 */

import java.io.*;
import java.util.*;

public class day9 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day9/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        // ----------part 1----------
        int[][] map = new int[inputs.size()][inputs.get(0).length()];

        for (int row = 0; row < map.length; row++) {
            String line = inputs.get(row);
            for (int col = 0; col < map[row].length; col++) {
                map[row][col] = Integer.parseInt(line.substring(col, col + 1));
            }
        }

        int risk = 0;
        ArrayList<Point> lows = new ArrayList<>();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                int val = map[row][col];
                if (row - 1 >= 0 && val >= map[row - 1][col]) {
                    continue;
                }
                if (row + 1 < map.length && val >= map[row + 1][col]) {
                    continue;
                }
                if (col - 1 >= 0 && val >= map[row][col - 1]) {
                    continue;
                }
                if (col + 1 < map[row].length && val >= map[row][col + 1]) {
                    continue;
                }

                lows.add(new Point(row, col));
                risk += 1 + val;
            }
        }

        System.out.println("Part 1 Answer: " + risk);

        // ----------part 2----------
        ArrayList<Integer> basins = new ArrayList<>();

        for (Point point : lows) {
            ArrayList<Point> usedPoints = new ArrayList<>();
            ArrayList<Point> newPoints = new ArrayList<>();

            newPoints.add(point);
            while (newPoints.size() > 0) {
                Point temp = newPoints.get(0);
                int row = temp.row;
                int col = temp.col;
                if (row - 1 >= 0 && map[row - 1][col] != 9) {
                    if (!visited(temp, usedPoints)) {
                        Point p = new Point(row - 1, col);
                        if (!visited(p, usedPoints) && !visited(p, newPoints)) {
                            newPoints.add(p);
                        }
                    }
                }
                if (row + 1 < map.length && map[row + 1][col] != 9) {
                    if (!visited(temp, usedPoints)) {
                        Point p = new Point(row + 1, col);
                        if (!visited(p, usedPoints) && !visited(p, newPoints)) {
                            newPoints.add(p);
                        }
                    }
                }
                if (col - 1 >= 0 && map[row][col - 1] != 9) {
                    if (!visited(temp, usedPoints)) {
                        Point p = new Point(row, col - 1);
                        if (!visited(p, usedPoints) && !visited(p, newPoints)) {
                            newPoints.add(p);
                        }
                    }
                }
                if (col + 1 < map[0].length && map[row][col + 1] != 9) {
                    if (!visited(temp, usedPoints)) {
                        Point p = new Point(row, col + 1);
                        if (!visited(p, usedPoints) && !visited(p, newPoints)) {
                            newPoints.add(p);
                        }
                    }
                }

                usedPoints.add(temp);
                newPoints.remove(0);
            }

            int i = 0;
            while(i < basins.size() && usedPoints.size() >= basins.get(i)) {
                i++;
            }

            basins.add(i, usedPoints.size());
        }

        int basLen = basins.size();
        int ans = basins.get(basLen - 1) * basins.get(basLen - 2) * basins.get(basLen - 3);
        System.out.println("Part 2 Answer: " + ans);
    }

    public static boolean visited(Point p, ArrayList<Point> nums) {
        for (int i = 0; i < nums.size(); i++) {
            Point temp = nums.get(i);
            if (temp.row == p.row && temp.col == p.col) {
                return true;
            }
        }

        return false;
    }
}