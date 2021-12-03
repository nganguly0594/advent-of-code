package D1_5.D3;


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
        Scanner scanfile = new Scanner(new File("texts/D3.txt"));
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, c11 = 0, c12 = 0;
        
        while (scanfile.hasNext())
            {
                String num = scanfile.next();
                
                if (num.charAt(0) == 49)
                    c1++;
                
                if (num.charAt(1) == 49)
                    c2++;
                
                if (num.charAt(2) == 49)
                    c3++;
                
                if (num.charAt(3) == 49)
                    c4++;
                
                if (num.charAt(4) == 49)
                    c5++;
                
                if (num.charAt(5) == 49)
                    c6++;
                
                if (num.charAt(6) == 49)
                    c7++;
                
                if (num.charAt(7) == 49)
                    c8++;
                
                if (num.charAt(8) == 49)
                    c9++;
                
                if (num.charAt(9) == 49)
                    c10++;
                
                if (num.charAt(10) == 49)
                    c11++;
                
                if (num.charAt(11) == 49)
                    c12++;
            }
        
        if (c1 > 500)
            c1 = 1;
        else
            c1 = 0;
        
        if (c2 > 500)
            c2 = 1;
        else
            c2 = 0;
        
        if (c3 > 500)
            c3 = 1;
        else
            c3 = 0;
        
        if (c4 > 500)
            c4 = 1;
        else
            c4 = 0;
        
        if (c5 > 500)
            c5 = 1;
        else
            c5 = 0;
        
        if (c6 > 500)
            c6 = 1;
        else
            c6 = 0;
        
        if (c7 > 500)
            c7 = 1;
        else
            c7 = 0;
        
        if (c8 > 500)
            c8 = 1;
        else
            c8 = 0;
        
        if (c9 > 500)
            c9 = 1;
        else
            c9 = 0;
        
        if (c10 > 500)
            c10 = 1;
        else
            c10 = 0;
        
        if (c11 > 500)
            c11 = 1;
        else
            c11 = 0;
        
        if (c12 > 500)
            c12 = 1;
        else
            c12 = 0;
        
        System.out.println("" + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12);
        
        //gamma rate = 001100001011 = 779
        //epsilon rate = 110011110100 = 3316
        
        System.out.println("Gamma x Epsilon = " + (779 * 3316));
    }
}
