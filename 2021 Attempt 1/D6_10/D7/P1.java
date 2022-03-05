package D6_10.D7;


/**
 * Write a description of class P1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.io.*;

public class P1
{
    public static void main (String[] args) throws IOException
    {
        Scanner scanfile = new Scanner(new File("texts/D7.txt"));
        String input = scanfile.nextLine().replace(",", " ");

        int sum = 0;
        int difference = 0;
        int lowest = 100000000;
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
                sum += difference;
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