package D1_5.D4;


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
        Scanner scanfile = new Scanner(new File("texts/D4.txt"));
        int c1 = 0, c2 = 0, c3 = 0;
        
        while (scanfile.hasNext())
            {
                String num = scanfile.next();
                
                if (num.charAt(7) == 49)
                    {
                        c1++;
                    }
                else
                    {
                        c2++;
                    }    
            }
        
        if (c1 > c2 || c1 == c2)
            {
                c3 = 0;
            }
        else
            {
                c3 = 1;
            }    
        System.out.println(c3);
        
        
        
        //001100111001 = 825
        //110100101111 = 3375
        //2784375
    }
}
