package day3;

/**
 * day3 
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class day3 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day3/input.txt"));

        //---------part 1----------
        ArrayList<String> nums = new ArrayList<>();
        while(scanfile.hasNext()) {
            nums.add(scanfile.nextLine());
        }

        int count = 0;
        String gamma = "";
        for (int i = 0; i < nums.get(0).length(); i++) {
            count = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j).charAt(i) == '1') {
                    count++;
                }
            }

            if (count > nums.size()/2) {
                gamma += "1";
            }
            else {
                gamma += "0";
            }
        }

        String epsilon = "";
        for (int i = 0; i < gamma.length(); i++) {
            if (gamma.charAt(i) == '1') {
                epsilon += "0";
            }
            else {
                epsilon += "1";
            }
        }

        System.out.println("Part 1 Answer: " + (toDecimal(gamma) * toDecimal(epsilon)));

        //----------part 2----------

        count = 0;
        char temp = '0';
        ArrayList<String> nums2 = new ArrayList<>(nums);

        for (int i = 0; nums.size() > 1; i++) {
            count = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j).charAt(i) == '1') {
                    count++;
                }
            }

            temp = '0';
            if (nums.size() % 2 != 0) {
                if (count > (nums.size() - 1)/2) {
                    temp = '1';
                }
            }
            else if (count >= nums.size()/2) {
                temp = '1';
            }
            
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j).charAt(i) != temp) {
                    nums.remove(j);
                    j--;
                }
            }
        }

        String oxygen = nums.get(0);
        
        count = 0;
        temp = '1';

        for (int i = 0; nums2.size() > 1; i++) {
            count = 0;
            for (int j = 0; j < nums2.size(); j++) {
                if (nums2.get(j).charAt(i) == '1') {
                    count++;
                }
            }

            System.out.println(nums2.size() + " " + count);
            temp = '1';
            if (count >= nums2.size()/2) {
                temp = '0';
            }
            
            for (int j = 0; j < nums2.size(); j++) {
                if (nums2.get(j).charAt(i) != temp) {
                    nums2.remove(j);
                    j--;
                }
            }
            System.out.println(nums2.get(0));
        }

        String co2 = nums2.get(0);

        System.out.println("Part 2 Answer: " + (toDecimal(oxygen) * toDecimal(co2)));

    }

    public static int toDecimal(String binary) {
        int length = binary.length();
        int num = 0;
        for (int i = 0; i < length; i++) {
            if (binary.charAt(i) == '1') {
                num += Math.pow(2, length - i - 1);
            }
        }
        return num;
    }
}