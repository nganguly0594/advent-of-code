package day8;
/**
 * day8
 */

import java.io.*;
import java.util.*;

public class day8 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day8/input.txt"));

        char[] directions = scanfile.nextLine().toCharArray();
        scanfile.nextLine();

        Map<String, ArrayList<String>> nodes = new HashMap<>();

        while (scanfile.hasNext()) {
            String[] line = scanfile.nextLine().replace(" = (", ", ").replace(")", "").split(", ");
            nodes.put(line[0], new ArrayList<>());
            nodes.get(line[0]).add(line[1]);
            nodes.get(line[0]).add(line[2]);
        }

        //----------part 1----------
        String curr = "AAA";

        int count = 0;

        while (!curr.equals("ZZZ")) {
            curr = (directions[count % directions.length] == 'L') ? nodes.get(curr).get(0) : nodes.get(curr).get(1);
            count++;
        }

        System.out.println("Part 1 Answer: " + count);

        //----------part 2----------
        ArrayList<String> ghosts = new ArrayList<>();
        
        for (String node : nodes.keySet()) {
            if (node.charAt(2) == 'A') {
                ghosts.add(node);
            }
        }

        ArrayList<Long> counts = new ArrayList<>();

        for (String ghost : ghosts) {
            int steps = 0;

            while (ghost.charAt(2) != 'Z') {
                ghost = (directions[steps % directions.length] == 'L') ? nodes.get(ghost).get(0) : nodes.get(ghost).get(1);
                steps++;
            }

            counts.add((long) steps);
        }

        long totalLCM = lcm(counts.get(0), counts.get(1));

        for (int i = 2; i < counts.size(); i++) {
            totalLCM = lcm(totalLCM, counts.get(i));
        }

        System.out.println("Part 2 Answer: " + totalLCM);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}