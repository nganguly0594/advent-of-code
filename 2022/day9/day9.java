package day9;

/**
 * day9
 */

import java.io.*;
import java.util.*;

public class day9 {
    public static char[][] grid;
    public static Point h;
    public static Point t;
    public static ArrayList<Point> knots;

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day9/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        grid = new char[10001][10001];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = '.';
            }
        }

        h = new Point(5000, 5000);
        t = new Point(5000, 5000);

        //----------part 1----------
        for (String s : inputs) {
            String[] parts = s.split(" ");
            for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
                moveGrid(parts[0]);
            }
        }

        System.out.println("Part 1 Answer: " + visitCount());

        //----------part 2----------
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = '.';
            }
        }

        knots = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            knots.add(new Point(5000, 5000));
        }

        for (String s : inputs) {
            String[] parts = s.split(" ");
            for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
                moveGrid2(parts[0]);
            }
        }

        System.out.println("Part 2 Answer: " + visitCount());
    }

    public static int visitCount() {
        int visited = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] != '.') {
                    visited++;
                }
            }
        }

        return visited + 1;
    }

    public static void moveGrid(String dir) {
        if (dir.equals("R")) {
            h.col++;
        }
        else if (dir.equals("L")) {
            h.col--;
        }
        else if (dir.equals("U")) {
            h.row--;
        }
        else {
            h.row++;
        }

        moveT();
    }

    public static void moveT() {
        if ((t.col == h.col && (t.row + 2 == h.row))) {
            grid[t.row][t.col] = '1';
            t.row++;
        }
        if ((t.col == h.col && (t.row - 2 == h.row))) {
            grid[t.row][t.col] = '1';
            t.row--;
        }
        if ((t.row == h.row && (t.col + 2 == h.col))) {
            grid[t.row][t.col] = '1';
            t.col++;
        }
        if ((t.row == h.row && (t.col - 2 == h.col))) {
            grid[t.row][t.col] = '1';
            t.col--;
        }
        if (t.row != h.row && t.col != h.col) {
            if ((t.col - 1 == h.col && t.row - 2 == h.row) || (t.col - 2 == h.col && t.row - 1 == h.row)) {
                grid[t.row][t.col] = '1';
                t.col--;
                t.row--;
            }
            if ((t.col - 2 == h.col && t.row + 1 == h.row) || (t.col - 1 == h.col && t.row + 2 == h.row)) {
                grid[t.row][t.col] = '1';
                t.col--;
                t.row++;
            }
            if ((t.col + 1 == h.col && t.row + 2 == h.row) || (t.col + 2 == h.col && t.row + 1 == h.row)) {
                grid[t.row][t.col] = '1';
                t.col++;
                t.row++;
            }
            if ((t.col + 2 == h.col && t.row - 1 == h.row) || (t.col + 1 == h.col && t.row - 2 == h.row)) {
                grid[t.row][t.col] = '1';
                t.col++;
                t.row--;
            }
        }
    }

    public static void moveGrid2(String dir) {
        if (dir.equals("R")) {
            knots.get(0).col++;
        }
        else if (dir.equals("L")) {
            knots.get(0).col--;
        }
        else if (dir.equals("U")) {
            knots.get(0).row--;
        }
        else {
            knots.get(0).row++;
        }

        for (int i = 0; i < knots.size() - 1; i++) {
            h = knots.get(i);
            t = knots.get(i + 1);
            boolean last = false;
            if (i == knots.size() - 2) {
                last = true;
            }
            moveT2(last);
        }
    }

    public static void moveT2(boolean las) {
        int[] rc = {t.row, t.col};
        boolean moved = false;

        if ((t.col == h.col && (t.row + 2 == h.row))) {
            moved = true;
            t.row++;
        }
        if ((t.col == h.col && (t.row - 2 == h.row))) {
            moved = true;
            t.row--;
        }
        if ((t.row == h.row && (t.col + 2 == h.col))) {
            moved = true;
            t.col++;
        }
        if ((t.row == h.row && (t.col - 2 == h.col))) {
            moved = true;
            t.col--;
        }
        if (t.row != h.row && t.col != h.col) {
            if ((t.col - 1 == h.col && t.row - 2 == h.row) || (t.col - 2 == h.col && t.row - 1 == h.row) || (t.col - 2 == h.col && t.row - 2 == h.row)) {
                moved = true;
                t.col--;
                t.row--;
            }
            if ((t.col - 2 == h.col && t.row + 1 == h.row) || (t.col - 1 == h.col && t.row + 2 == h.row) || (t.col - 2 == h.col && t.row + 2 == h.row)) {
                moved = true;
                t.col--;
                t.row++;
            }
            if ((t.col + 1 == h.col && t.row + 2 == h.row) || (t.col + 2 == h.col && t.row + 1 == h.row) || (t.col + 2 == h.col && t.row + 2 == h.row)) {
                moved = true;
                t.col++;
                t.row++;
            }
            if ((t.col + 2 == h.col && t.row - 1 == h.row) || (t.col + 1 == h.col && t.row - 2 == h.row) || (t.col + 2 == h.col && t.row - 2 == h.row)) {
                moved = true;
                t.col++;
                t.row--;
            }
        }

        if (las && moved) {
            grid[rc[0]][rc[1]] = '1';
        }
    }
}