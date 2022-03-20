package day11;

/**
 * day11
 */

import java.io.*;
import java.util.*;

public class day11 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day11/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        //----------part 1 and part 2----------
        int[][] octopi = new int[10][10];
        for (int row = 0; row < octopi.length; row++) {
            String line = inputs.get(row);
            for (int col = 0; col < octopi[row].length; col++) {
                octopi[row][col] = Integer.parseInt(line.substring(col, col + 1));
            }
        }

        int flashes = 0;
        int total_flashes = 0;
        int steps = 0;
        boolean together = false;
        while(!together) {
            steps++;
            for (int row = 0; row < octopi.length; row++) {
                for (int col = 0; col < octopi[row].length; col++) {
                    ArrayList<Octopus> counts = new ArrayList<>();
                    counts.add(new Octopus(row, col));

                    while (counts.size() > 0) {
                        Octopus octo = counts.get(0);
                        counts.remove(0);
                        int r = octo.row;
                        int c = octo.col;
                        octopi[r][c]++;

                        if (octopi[r][c] == 10) {
                            flashes++;

                            if (r - 1 >= 0 && c - 1 >= 0)
                                counts.add(new Octopus(r - 1, c - 1));
                            if (r - 1 >= 0)
                                counts.add(new Octopus(r - 1, c));
                            if (r - 1 >= 0 && c + 1 < 10)
                                counts.add(new Octopus(r - 1, c + 1));
                            if (c + 1 < 10)
                                counts.add(new Octopus(r, c + 1));
                            if (r + 1 < 10 && c + 1 < 10)
                                counts.add(new Octopus(r + 1, c + 1));
                            if (r + 1 < 10)
                                counts.add(new Octopus(r + 1, c));
                            if (r + 1 < 10 && c - 1 >= 0)
                                counts.add(new Octopus(r + 1, c - 1));
                            if (c - 1 >= 0)
                                counts.add(new Octopus(r, c - 1));
                        }
                    }
                }
            }

            int count = 0;
            for (int row = 0; row < octopi.length; row++) {
                for (int col = 0; col < octopi[row].length; col++) {
                    if (octopi[row][col] > 9) {
                        octopi[row][col] = 0;
                        count++;
                    }
                }
            }
            
            if (steps == 100) {
                total_flashes = flashes;
            }
            if (count == 100) {
                together = true;
            }
        }

        System.out.println("Part 1 Answer: " + total_flashes);
        System.out.println("Part 2 Answer: " + steps);
    }
}