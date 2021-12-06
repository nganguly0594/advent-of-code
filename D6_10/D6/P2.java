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
            
            int[] lanternfish = new int[300];
            
            for (int x = 0; x < lanternfish.length; x++)
                {
                    lanternfish[x] = scan.nextInt();
                }
            
            int[] lanternfish2 = lanternfish;
            int[] lanternfish3 = lanternfish2;
            int count = 0;
            int count2 = 0;
            int difference = 0;
            
            for (int x = 0; x < 256; x++)
                {
                    for (int y = 0; y < lanternfish2.length; y++)
                        {
                            lanternfish2[y]--;
                            
                            if (lanternfish2[y] == -1)
                                {
                                    lanternfish2[y] = 6;
                                    count++;
                                }
                        }
                    
                    if (count > count2)
                        {
                            difference = count - count2;
                            count2 = count;
                        }
                    
                    lanternfish3 = lanternfish2;
                    lanternfish2 = new int[300 + count];
                    
                    for (int a = 0; a < lanternfish3.length; a++)
                        {
                            lanternfish2[a] = lanternfish3[a];
                        }
                        
                    if (difference > 0)
                        {
                            for (int b = 0; b < difference; b++)
                                {
                                    lanternfish2[lanternfish3.length + b] = 8;
                                }
                            difference = 0;
                        }
                }
            
            System.out.println("Number of fish after 80 days: " + lanternfish2.length);
            
            
        }
}
