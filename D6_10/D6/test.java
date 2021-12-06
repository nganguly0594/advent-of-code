package D6_10.D6;


/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;

public class test
{
    public static void main (String[] args) throws IOException
        {
            Scanner scanfile = new Scanner(new File("texts/D6.txt"));
            
            String input = scanfile.nextLine().replace(",", " ");
            
            Scanner scan = new Scanner(input);
            
            long[] lanternfish = new long[5];
            
            for (int x = 0; x < lanternfish.length; x++)
                {
                    lanternfish[x] = scan.nextInt();
                }
            
            lanternfish = new long[4];
            
            for (int x = 0; x < lanternfish.length; x++)
                {
                    System.out.print(lanternfish[x] + " ");
                }
        }
}
