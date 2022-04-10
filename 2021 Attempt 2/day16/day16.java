package day16;

/**
 * day16
 */

import java.io.*;
import java.util.*;

public class day16 {
    public static int cursor = 0;
    public static int version_sum = 0;
    public static String packet = "";
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day16/input.txt"));
        String input = scanfile.nextLine();
        scanfile.nextLine();

        HashMap<String, String> hexKey = new HashMap<>();
        while (scanfile.hasNext()) {
            String[] parts = scanfile.nextLine().split(" = ");
            hexKey.put(parts[0], parts[1]);
        }

        for (int i = 0; i < input.length(); i += 4) {
            String num = input.substring(i, i + 1);
            input = input.substring(0, i) + hexKey.get(num) + input.substring(i + 1, input.length());
        }

        packet = input;

        //----------part 1----------
        parseDecide();

        System.out.println("Part 1 Answer: " + version_sum);
    }

    public static void parseDecide() {
        int version = toDecimal(packet.substring(cursor, cursor + 3));
        version_sum += version;
        cursor += 3;

        int packetType = toDecimal(packet.substring(cursor, cursor + 3));
        cursor += 3;
        if (packetType == 4) {
            parseLiteral();
        }
        else {
            parseOperator();
        }
    }

    public static void parseLiteral() {
        String literal = "";
        int next = toDecimal(packet.substring(cursor, cursor + 1));
        cursor += 1;

        while (next != 0) {
            literal += packet.substring(cursor, cursor + 4);
            cursor += 4;
            next = toDecimal(packet.substring(cursor, cursor + 1));
            cursor += 1;
        }

        literal += packet.substring(cursor, cursor + 4);
        cursor += 4;
    }

    public static void parseOperator() {
        int typeID = toDecimal(packet.substring(cursor, cursor + 1));
        cursor += 1;

        if (typeID == 0) {
            int length = toDecimal(packet.substring(cursor, cursor + 15));
            cursor += 15;
            int current = cursor;
            while (cursor < current + length) {
                parseDecide();
            }
        }
        else {
            int subpackets = toDecimal(packet.substring(cursor, cursor + 11));
            cursor += 11;
            int count = 0;
            while (count < subpackets) {
                count++;
                parseDecide();
            }
        }
    }

    public static int toDecimal(String binary) {
        int length = binary.length();
        int num = 0;
        for (int i = 0; i < length; i++) {
            if (binary.charAt(i) == '1') {
                num += Math.pow(2, length - 1 - i);
            }
        }
        return num;
    }
}