package day13;

/**
 * day13
 */

import java.io.*;
import java.util.*;

public class day13 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day13/input.txt"));
        ArrayList<int[]> arrayInputs = new ArrayList<>();
        ArrayList<int[]> foldInputs = new ArrayList<>();

        while (scanfile.hasNext()) {
            String line = scanfile.nextLine();
            if (line.equals("")) {
                continue;
            } else if (!line.contains("fold")) {
                String[] strings = line.split(",");
                int[] coords = { Integer.parseInt(strings[1]), Integer.parseInt(strings[0]) };
                arrayInputs.add(coords);
            } else {
                String[] strings = line.replace("=", " ").split(" ");
                int[] coords = new int[2];
                if (strings[2].equals("y")) {
                    coords[0] = 1;
                } else {
                    coords[0] = 2;
                }
                coords[1] = Integer.parseInt(strings[3]);
                foldInputs.add(coords);
            }
        }

        // ----------part 1 and part 2----------
        int ymax = 0;
        int xmax = 0;
        for (int i = 0; i < arrayInputs.size(); i++) {
            int y = arrayInputs.get(i)[0];
            int x = arrayInputs.get(i)[1];
            if (y > ymax) {
                ymax = y;
            }
            if (x > xmax) {
                xmax = x;
            }
        }

        int[][] map = new int[ymax + 1][xmax + 1];
        for (int i = 0; i < arrayInputs.size(); i++) {
            map[arrayInputs.get(i)[0]][arrayInputs.get(i)[1]]++;
        }

        int[][] newmap = new int[0][0];
        for (int i = 0; i < foldInputs.size(); i++) {
            int[] folds = foldInputs.get(i);
            if (folds[0] == 1) {
                int half = map.length / 2;
                int length = Math.abs(folds[1] - half) + half;
                newmap = new int[length][map[0].length];
            }
            else if (folds[0] == 2) {
                int half = map[0].length / 2;
                int length = Math.abs(folds[1] - half) + half;
                newmap = new int[map.length][length];
            }

            for (int y = 0; y < newmap.length; y++) {
                for (int x = 0; x < newmap[0].length; x++) {
                    if (map[y][x] > 0) {
                        newmap[y][x]++;
                    }
                }
            }

            if (folds[0] == 1) {
                for (int y = map.length - 1; y > newmap.length; y--) {
                    for (int x = 0; x < newmap[0].length; x++) {
                        int index = (-1 * y) + map.length - 1;
                        if (map[y][x] > 0) {
                            newmap[index][x]++;
                        }
                    }
                }
            }
            else if (folds[0] == 2) {
                for (int y = 0; y < newmap.length; y++) {
                    for (int x = map[0].length - 1; x > newmap[0].length; x--) {
                        int index = (-1 * x) + map[0].length - 1;
                        if (map[y][x] > 0) {
                            newmap[y][index]++;
                        }
                    }
                }
            }

            map = newmap.clone();

            if (i == 0) {
                int count = 0;
                for (int y = 0; y < map.length; y++) {
                    for (int x = 0; x < map[0].length; x++) {
                        if (map[y][x] > 0) {
                            count++;
                        }
                    }
                }

                System.out.println("Part 1 Answer: " + count);
            }
        }

        System.out.println("Part 2 Answer: ");
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] > 0) {
                    System.out.print("# ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}