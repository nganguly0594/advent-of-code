package day6;

/**
 * day6
 */

import java.io.*;
import java.util.*;

public class day6 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day6/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        //----------part 1----------
        String signal = inputs.get(0);

        int marker = 0;

        char one = signal.charAt(0);
        char two = signal.charAt(1);
        char three = signal.charAt(2);
        char four = signal.charAt(3);

        for (int i = 4; i < signal.length(); i++) {
            if (one == two || one == three || one == four || two == three || two == four || three == four) {
                one = two;
                two = three;
                three = four;
                four = signal.charAt(i);
            }
            else {
                marker = i;
                break;
            }
        }
        
        System.out.println("Part 1 Answer: " + marker);


        //----------part 2----------
        int message = 0;

        ArrayList<Character> lettersUsed = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            lettersUsed.add(signal.charAt(i));
        }

        for (int i = 14; i < signal.length(); i++) {
            Set<Character> lettersSet = new HashSet<Character>(lettersUsed);
            if (lettersSet.size() < lettersUsed.size()) {
                lettersUsed.remove(0);
                lettersUsed.add(signal.charAt(i));
            }
            else {
                message = i;
                break;
            }
        }

        System.out.println("Part 2 Answer: " + message);
    }
}