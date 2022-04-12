package day4;

/**
 * day4
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class day4 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day4/input.txt"));

        //---------part 1 and part 2----------
        String line = scanfile.nextLine();
        String[] strings = line.split(",");
        ArrayList<Integer> calls = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            calls.add(Integer.parseInt(strings[i]));
        }

        int[][] bingo = new int[5][5];

        int countmin = 1000;
        int countmax = 0;
        int scoremin = 0;
        int scoremax = 0;

        while (scanfile.hasNext()) {
            int sum = 0;
            
            for (int row = 0; row < bingo.length; row++) {
                for (int column = 0; column < bingo[0].length; column++) {
                    bingo[row][column] = scanfile.nextInt();
                    sum += bingo[row][column];
                }
            }
            
            int tempnum = 0;

            for (int i = 0; i < calls.size(); i++) {
                for (int row = 0; row < bingo.length; row++) {
                    for (int column = 0; column < bingo[0].length; column++) {
                        if (bingo[row][column] == calls.get(i)) {
                            tempnum = bingo[row][column];
                            sum -= tempnum;
                            bingo[row][column] = -1;
                        }
                    }
                }

                if (isBingo(bingo)) {
                    if (i < countmin) {
                        countmin = i;
                        scoremin = tempnum * sum;
                    }
                    if (i > countmax) {
                        countmax = i;
                        scoremax = tempnum * sum;
                    }
                    break;
                }
            }
        }

        System.out.println("Part 1 Answer: " + scoremin);
        System.out.println("Part 2 Answer: " + scoremax);
        
    }

    /**
     * checks if bingo yet
     */
    public static boolean isBingo(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            if (square[i][0] == square[i][1] &&
                square[i][0] == square[i][2] && 
                square[i][0] == square[i][3] &&
                square[i][0] == square[i][4]) {
                return true;
            }
            else if (square[0][i] == square[1][i] &&
                     square[0][i] == square[2][i] && 
                     square[0][i] == square[3][i] &&
                     square[0][i] == square[4][i]) {
                return true;
            }
        }

        return false;
    }
}