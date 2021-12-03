package D1_5.D1;

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
        Scanner scanfile = new Scanner(new File("texts/D1.txt"));
        
        int num1 = scanfile.nextInt();
        int num2 = scanfile.nextInt();
        int i = 0;
        
        while (scanfile.hasNext())
            {
                if (num1 < num2)
                    {
                        i++;
                    }
                num1 = num2;
                num2 = scanfile.nextInt();
            }
        
        if (num1 < num2)
            i++;
            
        System.out.println(i);
    }
}
