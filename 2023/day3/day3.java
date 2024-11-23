package day3;
/**
 * day3 
 */

import java.io.*;
import java.util.*;

public class day3 {
    static ArrayList<ArrayList<Character>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day3/input.txt"));

        while (scanfile.hasNext()) {
            ArrayList<Character> addList = new ArrayList<>();
            
            for (char c : scanfile.nextLine().toCharArray()) {
                addList.add(c);
            }

            map.add(addList);
        }

        //----------part 1----------
        int partSum = 0;
        
        for (int r = 0; r < map.size(); r++) {
            ArrayList<Character> chars = map.get(r);
            
            for (int c = 0; c < chars.size(); c++) {
                int l = 0;

                while (c < chars.size() && Character.isDigit(chars.get(c))) {
                    l++;
                    c++;
                }

                partSum += part(r, c - l, l);
            }
        }

        System.out.println("Part 1 Answer: " + partSum);

        //----------part 2----------
        int gearSum = 0;
        Map<Point, ArrayList<Integer>> gears = new HashMap<>();

        for (int r = 0; r < map.size(); r++) {
            ArrayList<Character> chars = map.get(r);
            
            for (int c = 0; c < chars.size(); c++) {
                int l = 0;

                while (c < chars.size() && Character.isDigit(chars.get(c))) {
                    l++;
                    c++;
                }

                int[] nums = part2(r, c - l, l);

                if (nums.length != 1) {
                    Point p = new Point(nums[0], nums[1]);
                    if (!gears.keySet().contains(p)) {
                        gears.put(p, new ArrayList<>());
                    }
                    gears.get(p).add(nums[2]);
                }
            }
        }

        for (Point p : gears.keySet()) {
            ArrayList<Integer> nums = gears.get(p);
            if (nums.size() == 2) {
                gearSum += (nums.get(0) * nums.get(1));
            }
        }

        System.out.println("Part 2 Answer: " + gearSum);
    }

    public static int part(int row, int col, int length) {
        if (length == 0) {
            return 0;
        }

        String value = "";

        for (int i = 0; i < length; i++) {
            value += map.get(row).get(col + i);
        }

        int num = Integer.parseInt(value);

        for (int i = 0; i < 3; i++) {
            if (check(row - 1 + i, col - 1) || check(row - 1 + i, col + length)) {
                return num;
            }
        }

        for (int i = 0; i < length; i++) {
            if (check(row - 1, col + i) || check(row + 1, col + i)) {
                return num;
            }
        }
        
        return 0;
    }

    public static int[] part2(int row, int col, int length) {
        if (length == 0) {
            return new int[]{-1};
        }

        String value = "";

        for (int i = 0; i < length; i++) {
            value += map.get(row).get(col + i);
        }

        int num = Integer.parseInt(value);

        for (int i = 0; i < 3; i++) {
            if (checkGear(row - 1 + i, col - 1)) {
                return new int[]{row - 1 + i, col - 1, num};
            }
            else if (checkGear(row - 1 + i, col + length)) {
                return new int[]{row - 1 + i, col + length, num};
            }
        }

        for (int i = 0; i < length; i++) {
            if (checkGear(row - 1, col + i)) {
                return new int[]{row - 1, col + i, num};
            }
            else if (check(row + 1, col + i)) {
                return new int[]{row + 1, col + i, num};
            }
        }
        
        return new int[]{-1};
    }

    public static boolean check(int row, int col) {
        if (row < 0 || row >= map.size() || col < 0 || col >= map.get(row).size()) {
            return false;
        }
        
        char c = map.get(row).get(col);
        return c != '.' && !Character.isDigit(c);
    }

    public static boolean checkGear(int row, int col) {
        if (row < 0 || row >= map.size() || col < 0 || col >= map.get(row).size()) {
            return false;
        }
        return map.get(row).get(col) == '*';
    }
}