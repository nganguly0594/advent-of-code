package test;

import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        String[] hello = {"hi", "hi", "hi", "hi"};
        String[] bye = hello.clone();
        bye[1] = "bye";
        for (int i = 0; i < hello.length; i++) {
            System.out.println(hello[i]);
        }
    }
}
