package day10;

/**
 * day10 
 */

import java.io.*;
import java.util.*;

public class day10 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day10/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        //----------part 1 and part 2----------
        int sum = 0;
        int x = 1;
        int cycle = 0;
        int i = 0;
        boolean first = true;
        String output = "";

        while (i < inputs.size()) {
            if (Math.abs(x - (cycle % 40)) <= 1) {
                output += "#";
            }
            else {
                output += ".";
            }
            
            cycle++;

            if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                sum += (x * cycle);
            }
            
            String[] parts = inputs.get(i).split(" ");

            if (parts[0].equals("noop")) {
                i++;
            }
            else {
                if (first) {
                    first = false;
                }
                else {
                    x += Integer.parseInt(parts[1]);
                    first = true;
                    i++;
                }
            }
        }

        System.out.println("Part 1 Answer: " + sum);
        System.out.println("Part 2 Answer: ");

        for (int index = 0; index < output.length(); index += 40) {
            System.out.println(output.substring(index, index + 40));
        }
    }
}