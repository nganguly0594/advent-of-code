package D6_10.D6;


/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class arraylist_practice
{
    public static void main (String[] args) throws IOException
    {
        Scanner in = new Scanner(new File("texts/D6.txt"));
        String input = in.nextLine().replace(",", " ");
        Scanner scan = new Scanner(input);
        
        ArrayList<Integer> lanternfish = new ArrayList<Integer>();
        while (scan.hasNext())
        {
            int i = scan.nextInt();
            lanternfish.add(i);
        }
        
        for (int i = 0; i < 80; i++)
        {
            int lanternfish2 = 0;
            for (int x = 0; x < lanternfish.size(); x++)
            {
                if (lanternfish.get(x) > 0)
                    lanternfish.set(x, lanternfish.get(x) - 1);
                else
                {
                    lanternfish.set(x, 6);
                    lanternfish2++;
                }
            }

            if (lanternfish2 > 0)
                {
                    for (int j = 0; j < lanternfish2; j++)
                        lanternfish.add(8);
                    
                    lanternfish2 = 0;
                }
            
        }

        System.out.println(lanternfish.size());
    }
}
