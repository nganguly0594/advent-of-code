package day11;
/**
 * day11
 */

import java.io.*;
import java.util.*;

public class day11 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day11/input.txt"));
        
        ArrayList<ArrayList<Point>> cosmos = new ArrayList<>();
        int row = 0;
        while (scanfile.hasNext()) {
            char[] s = scanfile.nextLine().toCharArray();
            ArrayList<Point> line = new ArrayList<>();
            for (int col = 0; col < s.length; col++) {
                line.add(new Point(row, col, s[col]));
            }
            cosmos.add(line);
            row++;
        }

        //----------part 1 and part 2----------
        ArrayList<Point> galaxies = new ArrayList<>();

        for (ArrayList<Point> line : cosmos) {
            for (Point p : line) {
                if (p.data == '#') {
                    galaxies.add(p);
                }
            }
        }

        long totalDistance = 0, crazyDistance = 0;

        for (int i = 0; i < galaxies.size() - 1; i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                totalDistance += distance(galaxies.get(i), galaxies.get(j), cosmos, 2);
                crazyDistance += distance(galaxies.get(i), galaxies.get(j), cosmos, 1000000);
            }
        }

        System.out.println("Part 1 Answer: " + totalDistance);
        System.out.println("Part 2 Answer: " + crazyDistance);
    }

    public static boolean isEmpty(ArrayList<Point> line) {
        for (Point p : line) {
            if (p.data == '#') {
                return false;
            }
        }
        return true;
    }

    public static long distance(Point one, Point two, ArrayList<ArrayList<Point>> map, int times) {
        int eCols = emptyCols(one.col, two.col, map);
        int eRows = emptyRows(one.row, two.row, map);
        return Math.abs(one.row - two.row) + Math.abs(one.col - two.col) + (long) ((eCols + eRows) * (times - 1));
    }

    public static int emptyCols(int one, int two, ArrayList<ArrayList<Point>> map) {
        int count = 0;
        
        for (int c = Math.min(one, two); c < Math.max(one, two); c++) {
            ArrayList<Point> column = new ArrayList<>();
            for (int r = 0; r < map.size(); r++) {
                column.add(map.get(r).get(c));
            }
            if (isEmpty(column)) {
                count++;
            }
        }

        return count;
    }

    public static int emptyRows(int one, int two, ArrayList<ArrayList<Point>> map) {
        int count = 0;
        
        for (int r = Math.min(one, two); r < Math.max(one, two); r++) {
            if (isEmpty(map.get(r))) {
                count++;
            }
        }

        return count;
    }
}