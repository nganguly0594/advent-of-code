package D6_10.D7;


/**
 * Write a description of class P1 here.
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
        Scanner scanfile = new Scanner(new File("texts/D7.txt"));
        String input = scanfile.nextLine().replace(",", " ");

        long sum = 0;
        int difference = 0;
        long lowest = 2000000000;
        int[] array = new int[1000];

        Scanner scan = new Scanner(input);
        for (int x = 0; x < array.length; x++)
            {
                int j = scan.nextInt();
                array[x] = j;
            }

        for (int i = 0; i < 3000; i++)
        {
            for (int x = 0; x < array.length; x++)
            {
                difference = Math.abs(array[x] - i);
                int summation = 0;
                for (int a = 1; a <= difference; a++)
                {
                    summation += a;
                }
                sum += summation;
            }

            if (sum < lowest)
            {
                lowest = sum;
            }
            
            sum = 0;
        }

        System.out.println("The lowest is: " + lowest);

        
    }
}