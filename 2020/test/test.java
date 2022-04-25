package test;

/**
 * test
 */

import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(scrambleWord("TAN"));
        System.out.println(scrambleWord("ABRACADABRA"));
        System.out.println(scrambleWord("WHOA"));
        System.out.println(scrambleWord("AARDVARK"));
        System.out.println(scrambleWord("EGGS"));
        System.out.println(scrambleWord("A"));
        System.out.println(scrambleWord(""));
    }

    public static String scrambleWord(String word) {
        String scramble = "";
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == 'A' && word.charAt(i + 1) != 'A') {
                scramble += word.substring(i + 1, i + 2) + word.substring(i, i + 1);
                i++;
            }
            else {
                scramble += word.substring(i, i + 1);
            }
        }
        if (scramble.length() != word.length()) {
            scramble += word.substring(word.length() - 1, word.length());
        }
        return scramble;
    }
}