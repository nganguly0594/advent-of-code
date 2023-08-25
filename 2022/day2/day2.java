package day2;

/**
 * day2 
 */

import java.io.*;
import java.util.*;

public class day2 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day2/input.txt"));

        //----------part 1----------
        ArrayList<Character> opponent = new ArrayList<>();
        ArrayList<Character> guide = new ArrayList<>();

        while (scanfile.hasNext()) {
            opponent.add(scanfile.next().charAt(0));
            char c = scanfile.next().charAt(0);
            if (c == 'X') {
                guide.add('A');
            }
            else if (c == 'Y') {
                guide.add('B');
            }
            else {
                guide.add('C');
            }
        }

        int totalScore = 0;

        for (int i = 0; i < opponent.size(); i++) {
            totalScore += score(opponent.get(i), guide.get(i));
        }

        System.out.println("Part 1 answer: " + totalScore);

        //----------part 2----------
        
        totalScore = 0;

        for (int i = 0; i < opponent.size(); i++) {
            char c = opponent.get(i);

            if (guide.get(i) == 'C') {
                totalScore += 6;
                if (c == 'A') {
                    totalScore += 2;
                }
                else if (c == 'B') {
                    totalScore += 3;
                }
                else {
                    totalScore += 1;
                }
            }
            else if (guide.get(i) == 'B') {
                totalScore += 3;
                if (c == 'A') {
                    totalScore += 1;
                }
                else if (c == 'B') {
                    totalScore += 2;
                }
                else {
                    totalScore += 3;
                }
            }
            else {
                if (c == 'A') {
                    totalScore += 3;
                }
                else if (c == 'B') {
                    totalScore += 1;
                }
                else {
                    totalScore += 2;
                }
            }
        }

        System.out.println("Part 2 answer: " + totalScore);
    }

    public static int score(char one, char two) {
        int sum = 0;
        if (two == 'A') {
            sum += 1;
        }
        else if (two == 'B') {
            sum += 2;
        }
        else {
            sum += 3;
        }

        if (one == two) {
            sum += 3;
        }
        else if ((one == 'A' && two == 'B') || (one == 'B' && two == 'C') || (one == 'C' && two == 'A')) {
            sum += 6;
        }
        
        return sum;
    }
}