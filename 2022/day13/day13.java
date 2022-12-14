package day13;

/**
 * day13
 */

import java.io.*;
import java.util.*;

public class day13 {
    public static String finalLeft;
    public static String finalRight;

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day13/input.txt"));

        ArrayList<String> inputs = new ArrayList<>();

        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        // ----------part 1----------
        ArrayList<String> leftInput = new ArrayList<>();
        ArrayList<String> rightInput = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            if (i % 3 == 0) {
                leftInput.add(inputs.get(i));
            } else if (i % 3 == 1) {
                rightInput.add(inputs.get(i));
            }
        }

        int sumIndices = 0;

        for (int i = 0; i < leftInput.size(); i++) {
            String left = leftInput.get(i);
            String right = rightInput.get(i);

            if (inOrder(left, right) == 1) {
                System.out.println(i + 1);
                sumIndices += i + 1;
            }
        }

        System.out.println("Part 1 Answer: " + sumIndices);

        // ----------part 2----------

        System.out.println("Part 2 Answer: ");
    }

    /*public static int inOrder(String left, String right) {
        if (left.length() == 1) {
            if (right.length() == 1) {
                if (Integer.parseInt(left) < Integer.parseInt(right)) {
                    return 1;
                }
                else if (Integer.parseInt(left) > Integer.parseInt(right)) {
                    return -1;
                }
                return 0;
            }
            return inOrder2("[" + left + "]", right);
        }
        if (right.length() == 1) {
            return inOrder2(left, "[" + right + "]");
        }

        ArrayList<String> leftParts = split(left);
        ArrayList<String> rightParts = split(right);

        for (int i = 0; i < Math.min(leftParts.size(), rightParts.size()); i++) {
            int compare = inOrder2(leftParts.get(i), rightParts.get(i));
            if (compare == 1) {
                return 1;
            }
            if (compare == -1) {
                return -1;
            }
        }

        if (leftParts.size() < rightParts.size()) {
            return 1;
        }
        if (rightParts.size() < leftParts.size()) {
            return -1;
        }
        return 0;
    }*/

    public static int inOrder(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return ((Integer) left).compareTo((Integer) right);
        }

        if (left instanceof Integer) {
            left = "[" + left + "]";
        }
        if (right instanceof Integer) {
            right = "[" + right + "]";
        }

        ArrayList<Object> leftParts = split((String) left);
        ArrayList<Object> rightParts = split((String) right);

        int i = 0;
        while (true) {
            if (i > leftParts.size() - 1 && i > rightParts.size() - 1) {
                return 0;
            }
            else if (i > leftParts.size() - 1 && i <= rightParts.size() - 1) {
                return -1;
            }
            else if (i <= leftParts.size() - 1 && i > rightParts.size() - 1) {
                return 1;
            }
            else {
                int compare = inOrder(leftParts.get(i), rightParts.get(i));
                if (compare != 0) {
                    return compare;
                }
            }
            i++;
        }
    }

    public static ArrayList<Object> split(String line) {
        Stack<Integer> brackets = new Stack<>();
        ArrayList<Object> parts = new ArrayList<>();

        String element = "";

        for (int i = 0; i < line.length(); i++) {
            String s = line.substring(i, i + 1);
            String next = "";
            if (i < line.length() - 1) {
                next = line.substring(i + 1, i + 2);
            }

            if (brackets.size() > 1 && !s.equals("[")) {
                element += s;
            } else if (brackets.size() == 1) {
                if (s.equals(",")) {
                    continue;
                } else if (Character.isDigit(s.charAt(0))) {
                    if (Character.isDigit(next.charAt(0))) {
                        parts.add(s + next);
                        i++;
                    }
                    else {
                        parts.add(s);
                    }
                }
            }

            if (s.equals("[")) {
                if (brackets.size() > 0) {
                    element += s;
                }
                brackets.push(1);
            } else if (s.equals("]")) {
                brackets.pop();
                if (element.length() > 0 && brackets.size() == 1) {
                    parts.add(element);
                    element = "";
                }
            }
        }

        for (int i = 0; i < parts.size(); i++) {
            String s = (String) parts.get(i);
            if (s.length() == 1 || (s.length() == 2 && s.charAt(0) != '[')) {
                parts.set(i, Integer.parseInt(s));
            }
        }

        return parts;
    }
}