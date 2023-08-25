package D6_10.D6; 


/**
 * Write a description of class P2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.io.*;

public class P2
{
    public static void main (String[] args) throws IOException
        {
            Scanner scanfile = new Scanner(new File("texts/D6.txt"));
            
            String input = scanfile.nextLine().replace(",", " ");
            
            Scanner scan = new Scanner(input);
            
            long[] lanternfish = new long[9];
            
            while(scan.hasNext())
                {
                    int i = scan.nextInt();
                    lanternfish[i]++;
                }
            
            long[] lanternfish2 = new long[9];
            for (int x = 0; x < 256; x++)
                {
                    lanternfish2[6] = lanternfish[0] + lanternfish[7];
                    lanternfish2[0] = lanternfish[1];
                    lanternfish2[1] = lanternfish[2];
                    lanternfish2[2] = lanternfish[3];
                    lanternfish2[3] = lanternfish[4];
                    lanternfish2[4] = lanternfish[5];
                    lanternfish2[5] = lanternfish[6];
                    lanternfish2[7] = lanternfish[8];
                    lanternfish2[8] = lanternfish[0];
                    lanternfish = lanternfish2.clone();
                }
            
            long sum = 0;
            for (int x = 0; x < 9; x++)
                {
                    sum += lanternfish[x];
                }
            
            System.out.println("Answer: " + sum);
        }
}