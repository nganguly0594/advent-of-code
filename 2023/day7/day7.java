package day7;
/**
 * day7
 */

import java.io.*;
import java.util.*;

public class day7 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day7/input.txt"));

        Map<String, Map<Character, Integer>> hands = new HashMap<>();

        while (scanfile.hasNext()) {
            String line = scanfile.nextLine();
            Map<Character, Integer> counts = new HashMap<>();
            
            for (char c : line.substring(0, 5).toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            hands.put(line, counts);
        }

        //----------part 1 and part 2----------
        ArrayList<String> sortedHands = new ArrayList<>();
        ArrayList<String> sortedJokers = new ArrayList<>();

        for (String hand : hands.keySet()) {
            int i = 0, j = 0;
            
            while (i < sortedHands.size() && compareHands(hand, sortedHands.get(i), hands, true)) {
                i++;
            }

            sortedHands.add(i, hand);

            while (j < sortedJokers.size() && compareHands(hand, sortedJokers.get(j), hands, false)) {
                j++;
            }

            sortedJokers.add(j, hand);
        }

        int rankSum = 0, jokerSum = 0;

        for (int i = 0; i < sortedHands.size(); i++) {
            int bid = Integer.parseInt(sortedHands.get(i).split(" ")[1]);
            rankSum += ((i + 1) * bid);

            int jokerBid = Integer.parseInt(sortedJokers.get(i).split(" ")[1]);
            jokerSum += ((i + 1) * jokerBid);
        }

        System.out.println("Part 1 Answer: " + rankSum);
        System.out.println("Part 2 Answer: " + jokerSum);
    }

    public static boolean compareHands(String handOne, String handTwo, Map<String, Map<Character, Integer>> hands, boolean partOne) {
        int one = (partOne) ? getType(hands.get(handOne)) : getTypeJoker(hands.get(handOne));
        int two = (partOne) ? getType(hands.get(handTwo)) : getTypeJoker(hands.get(handTwo));

        if (one == two) {
            for (int i = 0; i < 5; i++) {
                char charOne = (partOne) ? convert(handOne.charAt(i), true) : convert(handOne.charAt(i), false);
                char charTwo = (partOne) ? convert(handTwo.charAt(i), true) : convert(handTwo.charAt(i), false);
                
                if (charOne == charTwo) {
                    continue;
                }
                else {
                    return charOne > charTwo;
                }
            }
        }
        return one > two;
    }

    public static int getType(Map<Character, Integer> hand) {
        if (hand.keySet().size() == 1) {
            return 7;
        }
        if (hand.keySet().size() == 2) {
            if (hand.values().contains(1) || hand.values().contains(4)) {
                return 6;
            }
            else {
                return 5;
            }
        }
        if (hand.keySet().size() == 3) {
            if (hand.values().contains(3)) {
                return 4;
            }
            else {
                return 3;
            }
        }
        if (hand.keySet().size() == 4) {
            return 2;
        }
        return 1;
    }

    public static int getTypeJoker(Map<Character, Integer> hand) {
        if (hand.keySet().size() == 1 || (hand.keySet().size() == 2 && hand.keySet().contains('J'))) {
            return 7;
        }
        if (hand.keySet().size() == 2) {
            if (hand.values().contains(1) || hand.values().contains(4)) {
                return 6;
            }
            else {
                return 5;
            }
        }
        if (hand.keySet().size() == 3 && hand.keySet().contains('J')) {
            if (hand.values().contains(3) || hand.get('J') == 2) {
                return 6;
            }
            else {
                return 5;
            }
        }
        if (hand.keySet().size() == 3) {
            if (hand.values().contains(3)) {
                return 4;
            }
            else {
                return 3;
            }
        }
        if (hand.keySet().size() == 4) {
            if (hand.keySet().contains('J')) {
                return 4;
            }
            else {
                return 2;
            }
        }
        if (hand.keySet().size() == 5 && hand.keySet().contains('J')) {
            return 2;
        }
        return 1;
    }

    public static char convert(char letter, boolean partOne) {
        switch (letter) {
            case 'T':
                letter = (char) 58;
                break;
            case 'J':
                letter = (partOne) ? (char) 59 : (char) 49;
                break;
            case 'Q':
                letter = (char) 60;
                break;
            case 'K':
                letter = (char) 61;
                break;
            case 'A':
                letter = (char) 62;
                break;
        }
        return letter;
    }
}