package day10;
/**
 * day10
 */

import java.io.*;
import java.util.*;

public class day10 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day10/input.txt"));
        
        ArrayList<ArrayList<Character>> pipes = new ArrayList<>();

        int sRow = 0, sCol = 0;

        while (scanfile.hasNext()) {
            char[] chars = scanfile.nextLine().toCharArray();
            ArrayList<Character> charList = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                charList.add(chars[i]);
                if (chars[i] == 'S') {
                    sCol = i;
                    sRow = pipes.size();
                }
            }
            pipes.add(charList);
        }

        Point[][] points = new Point[pipes.size()][pipes.get(0).size()];
        for (int i = 0; i < pipes.size(); i++) {
            ArrayList<Character> pipe = pipes.get(i);
            for (int j = 0; j < pipe.size(); j++) {
                points[i][j] = new Point(i, j, pipe.get(j));
            }
        }

        //----------part 1 and part 2----------
        int[] coords = new int[3];

        ArrayList<Point> path = new ArrayList<>();

        path.add(points[sRow][sCol]);

        //direction: 1 right, 2 up, 3 left, 4 down
        coords = startSearch(sRow, sCol, pipes);

        int steps = 1;
        
        while (coords[0] != sRow || coords[1] != sCol) {
            int x = coords[0];
            int y = coords[1];
            char c = pipes.get(coords[0]).get(coords[1]);
            switch (coords[2]) {
                case 1:
                    switch (c) {
                        case '-': coords[1]--; break;
                        case 'L': coords[0]--; coords[2] = 4; break;
                        case 'F': coords[0]++; coords[2] = 2; break;
                    }
                    break;
                case 2:
                    switch (c) {
                        case '|': coords[0]++; break;
                        case 'L': coords[1]++; coords[2] = 3; break;
                        case 'J': coords[1]--; coords[2] = 1; break;
                    }
                    break;
                case 3:
                    switch (c) {
                        case '-': coords[1]++; break;
                        case 'J': coords[0]--; coords[2] = 4; break;
                        case '7': coords[0]++; coords[2] = 2; break;
                    }
                    break;
                case 4:
                    switch (c) {
                        case '|': coords[0]--; break;
                        case 'F': coords[1]++; coords[2] = 3; break;
                        case '7': coords[1]--; coords[2] = 1; break;
                    }
                    break;
            }
            path.add(points[x][y]);
            steps++;
        }

        ArrayList<Point> notPath = new ArrayList<>();

        for (int r = 0; r < points.length; r++) {
            for (int c = 0; c < points[r].length; c++) {
                if (!path.contains(points[r][c])) {
                    notPath.add(points[r][c]);
                }
            }
        }

        int inside = 0;
        for(Point p : notPath) {
            if(insideLoop(p, path)) {
                inside++;
            }
        }

        System.out.println("Part 1 Answer: " + (steps / 2));
        System.out.println("Part 2 Answer: " + inside);
    }

    public static int[] startSearch(int row, int col, ArrayList<ArrayList<Character>> map) {
        int[] locs = {row, col, -1};
        
        char c = '\0';

        if ((c = map.get(row).get(col + 1)) == '7' || c == '-' || c == 'J') {
            locs[1] = col + 1;
            locs[2] = 3;
            return locs;
        }
        else if ((c = map.get(row - 1).get(col)) == '7' || c == '|' || c == 'F') {
            locs[0] = row - 1;
            locs[2] = 4;
            return locs;
        }
        else if ((c = map.get(row).get(col - 1)) == 'F' || c == '-' || c == 'L') {
            locs[1] = col - 1;
            locs[2] = 1;
            return locs;
        }
        else {
            locs[0] = row + 1;
            locs[2] = 2;
            return locs;
        }
    }

    public static boolean insideLoop(Point p, ArrayList<Point> path) {
        boolean c = false;
        for (int i = 0, j = path.size() - 1; i < path.size(); j = i++) {
            Point a = path.get(i);
            Point b = path.get(j);
            if(((a.row > p.row) != (b.row > p.row)) && (p.col < a.col)) {
                c = (c) ? false : true;
            }
        }
        return c;
    }
}