package day10;

/**
 * day10
 */

import java.io.*;
import java.util.*;

public class day10 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day10/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        //----------part 1----------
        ArrayList<Character> errors = new ArrayList<>();
        ArrayList<Integer> opens = new ArrayList<>();

        for (int i = 0; i < inputs.size(); i++) {
            String s = inputs.get(i);
            for (int j = 0; j < s.length(); j++) {
                char symbol = s.charAt(j);
                if (symbol == '(' || symbol == '[' || symbol == '{' || symbol == '<') {
                    opens.add(convertone(symbol));
                }
                else
                {
                    int index = opens.size() - 1;
                    if (convertone(symbol) == opens.get(index)) {
                        opens.remove(index);
                    }
                    else {
                        errors.add(symbol);
                        inputs.remove(i);
                        i--;
                        break;
                    }
                }
            }
            opens.clear();
        }
        
        int sum = 0;
        for (int i = 0; i < errors.size(); i++) {
            sum += convertone(errors.get(i));
        }

        System.out.println("Part 1 Answer: " + sum);

        //----------part 2----------
        ArrayList<Long> scores = new ArrayList<>();

        for (int i = 0; i < inputs.size(); i++) {
            String s = inputs.get(i);
            for (int j = 0; j < s.length(); j++) {
                char symbol = s.charAt(j);
                if (symbol == '(' || symbol == '[' || symbol == '{' || symbol == '<') {
                    opens.add(converttwo(symbol));
                }
                else {
                    opens.remove(opens.size() - 1);
                }
            }

            long total_score = 0;
            for (int j = opens.size() - 1; j >= 0; j--) {
                total_score *= 5;
                total_score += opens.get(j);
                opens.remove(j);
            }

            int k = 0;
            while (k < scores.size() && total_score > scores.get(k)) {
                k++;
            }
            
            scores.add(k, total_score);
        }

        int middle = scores.size()/2;
        System.out.println("Part 2 Answer: " + scores.get(middle));
    }

    public static int convertone(char sym) {
        int num = 0;
        if (sym == '(' || sym == ')')
            num = 3;
        if (sym == '[' || sym == ']')
            num = 57;
        if (sym == '{' || sym == '}')
            num = 1197;
        if (sym == '<' || sym == '>')
            num = 25137;
        return num;
    }

    public static int converttwo(char sym) {
        int num = 0;
        if (sym == '(' || sym == ')')
            num = 1;
        if (sym == '[' || sym == ']')
            num = 2;
        if (sym == '{' || sym == '}')
            num = 3;
        if (sym == '<' || sym == '>')
            num = 4;
        return num;
    }
}