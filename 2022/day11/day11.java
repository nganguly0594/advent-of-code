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
        int count = 0;
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
            count++;
        }

        int numMonkeys = count / 7 + 1;

        ArrayList<Monkey> monkeys = new ArrayList<>();
        ArrayList<Monkey> monkeys2 = new ArrayList<>();
        for (int i = 0; i < numMonkeys; i++) {
            monkeys.add(new Monkey());
            monkeys2.add(new Monkey());
        }

        for (int i = 0; i < inputs.size(); i += 7) {
            String[] parts = inputs.get(i + 1).replace(",", "").trim().split(" ");

            Queue<Long> starting = new LinkedList<>();
            Queue<Long> starting2 = new LinkedList<>();
            for (int j = 2; j < parts.length; j++) {
                starting.add(Long.parseLong(parts[j]));
                starting2.add(Long.parseLong(parts[j]));

            }

            parts = inputs.get(i + 2).trim().split(" ");
            String oper = parts[4];
            String fact = parts[5];

            parts = inputs.get(i + 3).trim().split(" ");
            int testnum = Integer.parseInt(parts[3]);

            parts = inputs.get(i + 4).split(" ");
            Monkey first = monkeys.get(Integer.parseInt(parts[parts.length - 1]));
            Monkey third = monkeys2.get(Integer.parseInt(parts[parts.length - 1]));


            parts = inputs.get(i + 5).split(" ");
            Monkey second = monkeys.get(Integer.parseInt(parts[parts.length - 1]));
            Monkey fourth = monkeys2.get(Integer.parseInt(parts[parts.length - 1]));


            monkeys.get(i / 7).set(starting, oper, fact, testnum, first, second);
            monkeys2.get(i / 7).set(starting2, oper, fact, testnum, third, fourth);
        }

        // ----------part 1----------
        ArrayList<Long> inspects = new ArrayList<>();
        for (int i = 0; i < numMonkeys; i++) {
            inspects.add((long) 0);
        }

        int divisionFactor = 1;
        for (Monkey m : monkeys) {
            divisionFactor *= m.divisible;
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < monkeys.size(); j++) {
                inspects.set(j, inspects.get(j) + monkeys.get(j).turn(divisionFactor));
            }
        }

        long largest = 0;
        long second = 0;
        for (long inspect : inspects) {
            if (inspect > largest) {
                second = largest;
                largest = inspect;
            } else if (inspect > second) {
                second = inspect;
            }
        }

        System.out.println("Part 1 Answer: " + (largest * second));

        // ----------part 2----------
        inspects = new ArrayList<>();
        for (int i = 0; i < numMonkeys; i++) {
            inspects.add((long) 0);
        }

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < monkeys2.size(); j++) {
                inspects.set(j, inspects.get(j) + monkeys2.get(j).turn2(divisionFactor));
            }
        }

        largest = 0;
        second = 0;
        for (long inspect : inspects) {
            if (inspect > largest) {
                second = largest;
                largest = inspect;
            } else if (inspect > second) {
                second = inspect;
            }
        }

        System.out.println("Part 2 Answer: " + (largest * second));

    }
}