package day5;

/**
 * day5
 */

import java.io.*;
import java.util.*;

public class day5 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day5/input.txt"));
        
        ArrayList<String> inputs = new ArrayList<>();
        
        String line = scanfile.nextLine();
        while (!line.contains("move")) {
            inputs.add(line);
            line = scanfile.nextLine();
        }
        inputs.remove(inputs.size() - 1);

        ArrayList<String> moves = new ArrayList<>();
        moves.add(line);
        while (scanfile.hasNext()) {
            moves.add(scanfile.nextLine());
        }

        ArrayList<Stack<String>> stacks = new ArrayList<>();

        //----------part 1 and part 2----------
        Scanner linescan = new Scanner(inputs.get(inputs.size() - 1));
        int count = 0;
        while (linescan.hasNext()) {
            count++;
            linescan.next();
        }

        for (int i = 0; i < count; i++) {
            Stack<String> stack = new Stack<>();
            for (int j = inputs.size() - 1; j >= 0; j--) {
                line = inputs.get(j);
                if (line.substring(4 * i, 4 * i + 1).equals("[")) {
                    stack.push(line.substring(4 * i, 4 * i + 3));
                }
            }
            stacks.add(stack);
        }

        ArrayList<Stack<String>> stacks2 = new ArrayList<>();
        for (int i = 0; i < stacks.size(); i++) {
            Stack<String> stack2 = new Stack<>();
            stack2.addAll(stacks.get(i));
            stacks2.add(stack2);
        }

        for (int i = 0; i < moves.size(); i++) {
            Scanner scan = new Scanner(moves.get(i));
            scan.next();
            int num = scan.nextInt();
            scan.next();
            int from = scan.nextInt() - 1;
            scan.next();
            int to = scan.nextInt() - 1;

            for (int j = 0; j < num; j++) {
                stacks.get(to).push(stacks.get(from).pop());
            }

            Stack<String> pops = new Stack<>();
            for (int j = 0; j < num; j++) {
                pops.push(stacks2.get(from).pop());
            }
            for (int j = 0; j < num; j++) {
                stacks2.get(to).push(pops.pop());
            }
        }

        String answer = "";
        for (Stack<String> s : stacks) {
            answer += s.peek();
        }

        System.out.println("Part 1 Answer: " + answer.replace("[", "").replace("]", ""));

        answer = "";
        for (Stack<String> s : stacks2) {
            answer += s.peek();
        }

        System.out.println("Part 1 Answer: " + answer.replace("[", "").replace("]", ""));
    }
}