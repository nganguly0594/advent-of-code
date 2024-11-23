package day4;
/**
 * day4
 */

import java.io.*;
import java.util.*;

public class day4 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day4/input.txt"));
        ArrayList<Set<Integer>> winners = new ArrayList<>();
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();

        while (scanfile.hasNext()) {
            String[] parts = scanfile.nextLine().split(": ")[1].split(" \\| ");
            String[] wNums = parts[0].trim().split("\\s+");
            String[] yNums = parts[1].trim().split("\\s+");

            Set<Integer> wins = new HashSet<>();
            ArrayList<Integer> nums = new ArrayList<>();
            
            for (String wNum : wNums) {
                wins.add(Integer.parseInt(wNum));
            }

            for (String yNum : yNums) {
                nums.add(Integer.parseInt(yNum));
            }

            winners.add(wins);
            numbers.add(nums);
        }

        //----------part 1----------
        int totalWinnings = 0;

        for (int i = 0; i < winners.size(); i++) {
            Set<Integer> set = winners.get(i);
            int winnings = 0;
            int count = 0;

            for (int num : numbers.get(i)) {
                if (set.contains(num)) {
                    count++;

                    if (count == 1) {
                        winnings++;
                    }
                    else {
                        winnings *= 2;
                    }
                }
            }

            totalWinnings += winnings;
        }

        System.out.println("Part 1 Answer: " + totalWinnings);

        //----------part 2----------
        int[] cardCounts = new int[winners.size()];

        Arrays.fill(cardCounts, 1);

        for (int i = 0; i < winners.size(); i++) {
            Set<Integer> set = winners.get(i);
            int count = 0;

            for (int num : numbers.get(i)) {
                count = (set.contains(num)) ? count + 1 : count;
            }

            for (int index = i + 1; index < winners.size() && count > 0; index++, count--) {
                cardCounts[index] += cardCounts[i];
            }
        }

        int totalCards = 0;

        for (int count : cardCounts) {
            totalCards += count;
        }

        System.out.println("Part 2 Answer: " + totalCards);
    }
}