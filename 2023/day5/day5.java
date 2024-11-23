package day5;
/**
 * day5
 */

import java.io.*;
import java.util.*;

public class day5 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day5/input.txt"));
        ArrayList<Long> seeds = new ArrayList<>();

        String[] seedStrings = scanfile.nextLine().replace("seeds: ", "").split(" ");
        
        for (String ss : seedStrings) {
            seeds.add(Long.parseLong(ss));
        }

        scanfile.nextLine();

        ArrayList<ArrayList<ArrayList<Long>>> maps = new ArrayList<>();

        while (scanfile.hasNext()) {
            scanfile.nextLine();

            ArrayList<ArrayList<Long>> list = new ArrayList<>();
            String line = scanfile.nextLine();
            
            while (!line.isEmpty()) {
                ArrayList<Long> mapping = new ArrayList<>();
                
                for (String s : line.split(" ")) {
                    mapping.add(Long.parseLong(s));
                }

                list.add(mapping);
                try {
                    line = scanfile.nextLine();
                } catch (Exception e) {
                    line = "";
                }
            }

            maps.add(list);
        }

        //----------part 1----------
        long lowest = Long.MAX_VALUE;

        for (int i = 0; i < seeds.size(); i++) {
            long seed = seeds.get(i);
            
            for (int j = 0; j < maps.size(); j++) {
                ArrayList<ArrayList<Long>> map = maps.get(j);

                for (int k = 0; k < map.size(); k++) {
                    ArrayList<Long> conversion = map.get(k);

                    long dest = conversion.get(0), source = conversion.get(1), range = conversion.get(2);

                    long difference = source - dest;

                    if (seed >= source && seed < source + range) {
                        seed -= difference;
                        break;
                    }
                }
            }

            lowest = Math.min(lowest, seed);
        }

        System.out.println("Part 1 Answer: " + lowest);
        
        //----------part 2----------
        long location = 0;
        
        for (; location < Long.MAX_VALUE; location++) {
            System.out.println(location);
            long seed = location;
            
            for (int j = maps.size() - 1; j >= 0; j--) {
                ArrayList<ArrayList<Long>> map = maps.get(j);

                for (int k = 0; k < map.size(); k++) {
                    ArrayList<Long> conversion = map.get(k);

                    long dest = conversion.get(1), source = conversion.get(0), range = conversion.get(2);

                    long difference = source - dest;

                    if (seed >= source && seed < source + range) {
                        seed -= difference;
                        break;
                    }
                }
            }

            if (inRange(seed, seeds)) {
                break;
            }
        }

        System.out.println("Part 2 Answer: " + location);
    }

    public static boolean inRange(long num, ArrayList<Long> seeds) {
        for (int i = 0; i < seeds.size(); i += 2) {
            if (num >= seeds.get(i) && num < seeds.get(i) + seeds.get(i + 1)) {
                return true;
            }
        }
        return false;
    }
}