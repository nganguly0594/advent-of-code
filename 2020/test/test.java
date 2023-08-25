package test;

/**
 * test
 */ 

import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(summation(20));
    }

    public static long summation(long num) {
        if (num == 1) {
            return 1;
        }
        else {
            return num + summation(num - 1);
        }
    }
}