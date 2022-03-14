package day8;

/**
 * day8
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class day8 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day8/input.txt"));
        ArrayList<String[]> inputs = new ArrayList<>();
        ArrayList<String[]> outputs = new ArrayList<>();

        //----------part 1----------
        int count = 0;
        while (scanfile.hasNext()) {
            String line = scanfile.nextLine().replace("|", "");
            Scanner scan = new Scanner(line);

            String[] ins = new String[10];
            for (int i = 0; i < 10; i++) {
                String input = scan.next();
                ins[i] = input;
            }
            inputs.add(ins);

            String[] outs = new String[4];
            for (int i = 0; i < 4; i++) {
                String output = scan.next();
                outs[i] = output;

                int length = output.length();
                if (length == 2 || length == 3 || length == 4 || length == 7) {
                    count++;
                }
            }
            outputs.add(outs);
        }

        System.out.println("Part 1 Answer: " + count);

        //----------part 2----------
        int sum = 0;
        for (int i = 0; i < inputs.size(); i++) {
            String zero = "", one = "", two = "", three = "", four = "", five = "", six = "", seven = "", eight = "", nine = "";
            String a = "", b = "", c = "", d = "", e = "", f = "", g = "";
            for (int j = 0; j < inputs.get(i).length; j++) {
                String temp = inputs.get(i)[j];
                if (temp.length() == 2) {
                    one = temp;
                }
                if (temp.length() == 4) {
                    four = temp;
                }
                if (temp.length() == 3) {
                    seven = temp;
                }
                if (temp.length() == 7) {
                    eight = temp;
                }
            }

            for (int j = 0; j < 3; j++) {
                String temp = seven.substring(j, j + 1);
                if (!one.contains(temp)) {
                    a = temp;
                }
                else if (c.length() != 0) {
                    f = temp;
                }
                else {
                    c = temp;
                }
            }

            for (int j = 0; j < 4; j++) {
                String temp = four.substring(j, j + 1);
                if (!temp.equals(f) && !temp.equals(c)) {
                    if (b.length() == 0) {
                        b = temp;
                    }
                    else {
                        d = temp;
                    }
                }
            }

            for (int j = 0; j < 7; j++) {
                String temp = eight.substring(j, j + 1);
                if (!temp.equals(a) && !temp.equals(b) && !temp.equals(c) && !temp.equals(d) && !temp.equals(f)) {
                    if (e.length() == 0) {
                        e = temp;
                    }
                    else {
                        g = temp;
                    }
                }
            }

            for (int j = 0; j < inputs.get(i).length; j++) {
                String temp = inputs.get(i)[j];
                if (temp.length() == 6) {
                    if (!temp.contains(e) || !temp.contains(g)) {
                        nine = temp;
                    }
                    else if (!temp.contains(c) || !temp.contains(f)) {
                        six = temp;
                    }
                    else if (!temp.contains(b) || !temp.contains(d)) {
                        zero = temp;
                    }
                }
                else if (temp.length() == 5) {
                    if (temp.contains(c) && temp.contains(f)) {
                        three = temp;
                    }
                    else if (temp.contains(b) && temp.contains(d)) {
                        five = temp;
                    }
                    else {
                        two = temp;
                    }
                }
            }

            String[] digits = new String[4];
            for (int j = 0; j < outputs.get(i).length; j++) {
                String digit = outputs.get(i)[j];
                int length = digit.length();
                if (length == 2) {
                    digits[j] = "1";
                }
                else if (length == 3) {
                    digits[j] = "7";
                }
                else if (length == 4) {
                    digits[j] = "4";
                }
                else if (length == 5) {
                    String number = "";

                    number = isDigit(number, length, digit, "2", two);
                    number = isDigit(number, length, digit, "3", three);
                    number = isDigit(number, length, digit, "5", five);

                    digits[j] = number;
                }
                else if (length == 6) {
                    String number = "";

                    number = isDigit(number, length, digit, "6", six);
                    number = isDigit(number, length, digit, "9", nine);
                    number = isDigit(number, length, digit, "0", zero);

                    digits[j] = number;
                }
                else {
                    digits[j] = "8";
                }
            }

            String out = "";
            for (int j = 0; j < digits.length; j++) {
                out += digits[j];
            }

            int outdig = Integer.parseInt(out);
            sum += outdig;
        }

        System.out.println("Part 2 Answer: " + sum);
    }

    /**
     * isDigit
     */
    public static String isDigit(String num, int len, String dig, String result, String digit) {
        if (num.equals("")) {
            for (int i = 0; i < len; i++) {
                if (digit.contains(dig.substring(i, i + 1))) {
                    num = result;
                } else {
                    num = "";
                    break;
                }
            }
        }
        return num;
    }

}