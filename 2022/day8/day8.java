package day8;

/**
 * day8
 */

import java.io.*;
import java.util.*;

public class day8 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day8/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        int[][] trees = new int[inputs.size()][inputs.get(0).length()];
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < inputs.get(0).length(); j++) {
                trees[i][j] = Integer.parseInt(inputs.get(i).substring(j, j + 1));
            }
        }

        //----------part 1 and part 2----------
        int count = 0;
        int scenicScore = 0;

        for (int r = 0; r < trees.length; r++) {
            for (int c = 0; c < trees[0].length; c++) {
                if (visible(trees, r, c)) {
                    count++;
                }

                if (score(trees, r, c) > scenicScore) {
                    scenicScore = score(trees, r, c);
                }
            }
        }
        
        System.out.println("Part 1 Answer: " + count);
        System.out.println("Part 2 Answer: " + scenicScore);

    }

    public static boolean visible(int[][] map, int r, int c) {
        if (r == 0 || c == 0 || r == map.length - 1 || c == map[0].length - 1) {
            return true;
        }

        boolean vis1 = true;
        for (int row = r + 1; row < map.length; row++) {
            if (map[row][c] >= map[r][c]) {
                vis1 = false;
            }
        }

        boolean vis2 = true;
        for (int row = r - 1; row >= 0; row--) {
            if (map[row][c] >= map[r][c]) {
                vis2 = false;
            }
        }

        boolean vis3 = true;
        for (int col = c + 1; col < map[0].length; col++) {
            if (map[r][col] >= map[r][c]) {
                vis3 = false;
            }
        }

        boolean vis4 = true;
        for (int col = c - 1; col >= 0; col--) {
            if (map[r][col] >= map[r][c]) {
                vis4 = false;
            }
        }

        return vis1 || vis2 || vis3 || vis4;
    }

    public static int score(int[][] map, int r, int c) {
        int score1 = 0;
        for (int row = r + 1; row < map.length; row++) {
            if (map[row][c] < map[r][c]) {
                score1++;
            }
            else if (map[row][c] == map[r][c]) {
                score1++;
                break;
            }
            else {
                break;
            }
        }

        int score2 = 0;
        for (int row = r - 1; row >= 0; row--) {
            if (map[row][c] < map[r][c]) {
                score2++;
            }
            else if (map[row][c] == map[r][c]) {
                score2++;
                break;
            }
            else {
                break;
            }
        }

        int score3 = 0;
        for (int col = c + 1; col < map[0].length; col++) {
            if (map[r][col] < map[r][c]) {
                score3++;
            }
            else if (map[r][col] == map[r][c]) {
                score3++;
                break;
            }
            else {
                break;
            }
        }

        int score4 = 0;
        for (int col = c - 1; col >= 0; col--) {
            if (map[r][col] < map[r][c]) {
                score4++;
            }
            else if (map[r][col] == map[r][c]) {
                score4++;
                break;
            }
            else {
                break;
            }
        }

        return score1 * score2 * score3 * score4;
    }
}