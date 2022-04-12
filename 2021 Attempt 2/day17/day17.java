package day17;

/**
 * day17
 */

import java.io.*;
import java.util.*;

public class day17 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day17/input.txt"));
        String[] input = scanfile.nextLine().replace("target area: x=", "").replace("y=", "").replace(",", "").replace("..", " ").split(" ");
        int[] target = new int[4];
        for (int i = 0; i < 4; i++) {
            target[i] = Integer.parseInt(input[i]);
        }

        //----------part 1 and part 2----------
        int paths = 0;
        int maximumY = 0;
        for (int x = 0; x < 185; x++) {
            for (int y = -120; y < 120; y++) {
                int high = launchProbe(x, y, target);
                if (high != -1) {
                    if (high > maximumY) {
                        maximumY = high;
                    }
                    paths++;
                }
            }
        }

        System.out.println("Part 1 Answer: " + maximumY);
        System.out.println("Part 2 Answer: " + paths);
    }

    public static int launchProbe(int x, int y, int[] bounds) {
        int maxHeight = 0;
        int xPos = 0;
        int yPos = 0;

        while (xPos + x <= bounds[1] && yPos + y >= bounds[2]) {
            xPos += x;
            yPos += y;
            if (x < 0) {
                x += 1;
            }
            else if (x > 0) {
                x -= 1;
            }
            y -= 1;

            if (yPos > maxHeight) {
                maxHeight = yPos;
            }
        }

        if (xPos < bounds[0] || yPos > bounds[3]) {
            maxHeight = -1;
        }

        return maxHeight;
    }
}