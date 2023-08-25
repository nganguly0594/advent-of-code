package day12;

/**
 * day12 
 */

import java.io.*;
import java.util.*;

public class day12 {
    public static Point start;
    public static Point curr;
    public static Point[][] grid;

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day12/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        grid = new Point[inputs.size()][inputs.get(0).length()];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                Point temp = new Point(r, c, inputs.get(r).charAt(c), Integer.MAX_VALUE);
                if (temp.val == 'S') {
                    start = temp;
                    start.val = 96;
                    start.distance = 0;
                    start.prev = null;
                    grid[r][c] = start;
                }
                else if (temp.val == 'E') {
                    temp.val = 123;
                    grid[r][c] = temp;
                }
                else {
                    grid[r][c] = temp;
                }
            }
        }

        // ----------part 1 and part 2----------
        Queue<Point> worklist = new LinkedList<>();
        worklist.add(start);

        int steps = 0;
        int steps2 = 0;

        while (!worklist.isEmpty()) {
            curr = worklist.remove();

            if (curr.val == 123) {
                while (curr.prev != null) {
                    steps++;
                    if (steps2 == 0 && curr.val == 'a') {
                        steps2 = steps;
                    }
                    curr = curr.prev;
                }
                break;
            }

            ArrayList<Point> neighbors = getNeighbors(curr);

            for (int i = 0; i < neighbors.size(); i++) {
                Point explore = neighbors.get(i);
                int dist = curr.distance + 1;
                if (explore.val > curr.val + 1) {
                    continue;
                }
                if (dist < explore.distance) {
                    explore.prev = curr;
                    explore.distance = dist;
                    worklist.add(explore);
                }
            }
        }

        System.out.println("Part 1 Answer: " + (steps - 2));
        System.out.println("Part 2 Answer: " + (steps2 - 4));
    }

    public static ArrayList<Point> getNeighbors(Point p) {
        ArrayList<Point> around = new ArrayList<>();
        if (p.row - 1 >= 0) {
            around.add(grid[p.row - 1][p.col]);
        }
        if (p.row + 1 < grid.length) {
            around.add(grid[p.row + 1][p.col]);
        }
        if (p.col - 1 >= 0) {
            around.add(grid[p.row][p.col - 1]);
        }
        if (p.col + 1 < grid[0].length) {
            around.add(grid[p.row][p.col + 1]);
        }

        return around;
    }
}