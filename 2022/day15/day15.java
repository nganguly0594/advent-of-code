package day15;

/**
 * day15
 */

import java.io.*;
import java.util.*;

public class day15 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day15/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        //----------part 1----------
        ArrayList<Point> sensors = new ArrayList<>();
        ArrayList<Point> beacons = new ArrayList<>();
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> yesBeacons = new ArrayList<>();

        for (int i = 0; i < inputs.size(); i++) {
            String[] parts = inputs.get(i).replace(":","").replace(",","").split(" ");
            
            int sx = Integer.parseInt(parts[2].split("=")[1]);
            int sy = Integer.parseInt(parts[3].split("=")[1]);
            int bx = Integer.parseInt(parts[8].split("=")[1]);
            int by = Integer.parseInt(parts[9].split("=")[1]);
            
            if (by == 2000000) {
                yesBeacons.add(bx);
            }

            sensors.add(new Point(sy, sx));
            beacons.add(new Point(by, bx));
            distances.add(Math.abs(sx - bx) + Math.abs(sy - by));
        }

        int emptyCount = 0;

        for (int x = -5000000; x < 5000000; x++) {
            if (yesBeacons.contains(x)) {
                continue;
            }
            else {
                emptyCount += possible(x, 2000000, sensors, distances) ? 0 : 1;
            }
        }
        
        System.out.println("Part 1 Answer: " + emptyCount);


        //----------part 2----------
        long tuningFreq = 0;

        System.out.println("Part 2 Answer: " + tuningFreq);
    }

    public static boolean possible(int x, int y, ArrayList<Point> sens, ArrayList<Integer> dists) {
        for (int i = 0; i < sens.size(); i++) {
            if (Math.abs(x - sens.get(i).col) + Math.abs(y - sens.get(i).row) <= dists.get(i)) {
                return false;
            }
        }
        return true;
    }
}