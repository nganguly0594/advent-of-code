package D1_5.D3;


/**
 * Write a description of class P2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.io.*;

public class P2_2
{
    public static void main (String[] args) throws IOException
    {    
        Scanner scanfile = new Scanner(new File("texts/D3.txt"));
        while (scanfile.hasNext())
            {
                String num = scanfile.next();
                
                if (num.charAt(0) == 49)
                    {
                        System.out.println(num);
                    }
            }
    }
}   
