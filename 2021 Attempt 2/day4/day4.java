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

        //---------part 1----------
        String line = scanfile.nextLine().replace(",", " ");
        Scanner scan1 = new Scanner(line);
        ArrayList<Integer> calls = new ArrayList<>();

        while (scan1.hasNext()) {
            calls.add(Integer.parseInt(scan1.next()));
        }

        int[][] bingo = new int[5][5];

        while (scanfile.hasNext()) {
            
            playBingo();

        }
    }

    /**
     * sets bingo board
     */
    public void playBingo {
        
    }
}