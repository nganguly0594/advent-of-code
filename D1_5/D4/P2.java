package D1_5.D4;


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
        Scanner scanfile = new Scanner(new File("texts/D4.txt"));
        while (scanfile.hasNext())
            {
                String num = scanfile.next();
                
                if (num.charAt(7) == 48)
                    {
                        System.out.println(num);
                    }
            }
    }
}   
