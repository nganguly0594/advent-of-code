package day13;
/**
 * day13
 */

import java.io.*;
import java.util.*;

public class day13 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day13/input.txt"));
        
        ArrayList<ArrayList<ArrayList<Point>>> patterns = new ArrayList<>();

        while (scanfile.hasNext()) {
            String l = "";
            int r = 0;
            ArrayList<ArrayList<Point>> pattern = new ArrayList<>();

            while (scanfile.hasNext() && !(l = scanfile.nextLine()).isEmpty()) {
                ArrayList<Point> line = new ArrayList<>();
                char[] symbols = l.toCharArray();

                for (int c = 0; c < symbols.length; c++) {
                    line.add(new Point(r, c, symbols[c]));
                }
                r++;
                pattern.add(line);
            }

            patterns.add(pattern);
        }

        //----------part 1----------
        /*int reflectionSum = 0;

        for (ArrayList<ArrayList<Point>> pattern : patterns) {
            int cols;
            if ((cols = findVertical(pattern, true)) != -1) {
                reflectionSum += cols;
                continue;
            }
            reflectionSum += (100 * findHorizontal(pattern, true));
        }

        System.out.println("Part 1 Answer: " + reflectionSum);*/

        //----------part 2----------
        int smudgeSum = 0;

        for (ArrayList<ArrayList<Point>> pattern : patterns) {
            for (ArrayList<Point> pa : pattern) {
                for (Point p : pa) {
                    System.out.print(p);
                }
                System.out.println();
            }
            int cols;
            if ((cols = findVertical(pattern, false)) != -1) {
                smudgeSum += cols;
                continue;
            }
            smudgeSum += (100 * findHorizontal(pattern, false));
        }

        System.out.println("Part 2 Answer: " + smudgeSum);

        /*
            for (ArrayList<Point> pa : pattern) {
                for (Point p : pa) {
                    System.out.print(p);
                }
                System.out.println();
            }
        */
    }

    public static int findVertical(ArrayList<ArrayList<Point>> pattern, boolean partOne) {
        int c = 1;
        boolean found = false;
        
        for (; !found && c < pattern.get(0).size(); c++) {
            int mistakes = 0;
            found = true;
            for (int r = 0; r < pattern.size(); r++) {
                if (pattern.get(r).get(c - 1).data != pattern.get(r).get(c).data) {
                    if (partOne || mistakes > 1) {
                        found = false;
                        break;
                    }
                    else if (mistakes < 2) {
                        mistakes++;
                    }
                }
            }
            found = (found && mistakes < 2) ? (partOne) ? checkVert(c, pattern, 10) : checkVert(c, pattern, mistakes) : false;
        }

        return (found) ? --c : -1;
    }

    public static boolean checkVert(int col, ArrayList<ArrayList<Point>> pattern, int miss) {
        for (int first = col - 2, last = col + 1; first >= 0 && last < pattern.get(0).size(); first--, last++) {
            for (int r = 0; r < pattern.size(); r++) {
                if (pattern.get(r).get(first).data != pattern.get(r).get(last).data) {
                    if (miss > 1) {
                        return false;
                    }
                    else {
                        miss++;
                    }
                }
            }
        }
        if (miss != 10 && miss > 1) {
            return false;
        }
        return true;
    }

    public static int findHorizontal(ArrayList<ArrayList<Point>> pattern, boolean partOne) {
        int r = 1;

        for (boolean found = false; !found; r++) {
            int mistakes = 0;
            found = true;
            for (int c = 0; c < pattern.get(r).size(); c++) {
                if (pattern.get(r - 1).get(c).data != pattern.get(r).get(c).data) {
                    if (partOne || mistakes > 1) {
                        found = false;
                        break;
                    }
                    else if (mistakes < 2) {
                        mistakes++;
                    }
                }
            }
            found = (found && mistakes < 2) ? (partOne) ? checkHoriz(r, pattern, 10) : checkHoriz(r, pattern, mistakes) : false;
        }

        return --r;
    }

    public static boolean checkHoriz(int row, ArrayList<ArrayList<Point>> pattern, int miss) {
        for (int first = row - 2, last = row + 1; first >= 0 && last < pattern.size(); first--, last++) {
            for (int c = 0; c < pattern.get(0).size(); c++) {
                if (pattern.get(first).get(c).data != pattern.get(last).get(c).data) {
                    if (miss > 1) {
                        return false;
                    }
                    else {
                        miss++;
                    }
                }
            }
        }
        if (miss != 10 && miss > 1) {
            return false;
        }
        return true;
    }
}