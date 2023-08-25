package D1_5.D1;

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
        Scanner scanfile = new Scanner(new File("texts/D1.txt"));
        Scanner scanfile2 = new Scanner(new File("texts/D1.txt"));
        
        int num1 = scanfile.nextInt();
        int num2 = scanfile.nextInt();
        int num3 = scanfile.nextInt();
        scanfile2.nextInt();
        int num4 = scanfile2.nextInt();
        int num5 = scanfile2.nextInt();
        int num6 = scanfile2.nextInt();
        int sum1 = num1 + num2 + num3;
        int sum2 = num4 + num5 + num6;
        int i = 0;
        
        while (scanfile2.hasNext())
            {
                if (sum1 < sum2)
                    {
                        i++;
                    }
                sum1 = sum2;
                num4 = num5;
                num5 = num6;
                num6 = scanfile2.nextInt();
                sum2 = num4 + num5 + num6;
            }
        
        if (sum1 < sum2)
            i++;
            
        System.out.println(i);
    }
}
