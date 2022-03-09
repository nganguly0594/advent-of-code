package day9;

/**
 * day9
 */

import java.io.*;
import java.util.Scanner;

public class day9 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day9/input.txt"));

        //----------part 1----------
        int[][] map = new int[100][100];
        for (int r = 0; r < 100; r++) {
            String line = scanfile.nextLine();
            for (int c = 0; c < 100; c++) {
                map[r][c] = Integer.parseInt(line.substring(c, c + 1));
            }
        }
        
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                System.out.println(map[r][c]);
            }
        }
    }
}