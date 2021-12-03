package D1_5.D3;


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
        Scanner scanfile = new Scanner(new File("texts/D3.txt"));
        Scanner scanfile2 = new Scanner(new File("texts/D3.txt"));
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, c11 = 0, c12 = 0;
        int i = 0;
        String result = "", result2 = "";
        
        while(scanfile.hasNext())
            {
                while (scanfile.hasNext())
                    {
                        String num = scanfile.next();
                        
                        if (num.charAt(0) == 49)
                            c1++;
                        else
                            c2++;
                        
                    }
                
                if (c1 > c2 || c1 == c2)
                    c3 = 1;
                else
                    c3 = 0;
                
                while (scanfile2.hasNext())
                    {
                        String num = scanfile2.next();
                        
                        if (num.charAt(0) != c3)
                            num.replace("0", "").replace("1", "");
                            
                        result += "\n" + num;
                    }
                
                Scanner in = new Scanner(result);
                Scanner in2 = new Scanner(result);
                c1 = 0;
                c2 = 0;
                c3 = 0;
                while (in.hasNext())
                    {
                        String num = in.next();
                        
                        if (num.charAt(1) == 49)
                            c1++;
                        else
                            c2++;
                        
                    }
                
                if (c1 > c2 || c1 == c2)
                    c3 = 1;
                else
                    c3 = 0;
                
                while (in2.hasNext())
                    {
                        String num = in2.next();
                        
                        if (num.charAt(1) != c3)
                            num.replace("0", "").replace("1", "");
                            
                        result2 += "\n" + num;
                    }
                System.out.println(result2);
                i++;
            }
                
        /*
        while (scanfile.hasNext())
            {
                String num = scanfile.next();
                
                if (num.charAt(0) == 49)
                    if (num.charAt(1) == 49)
                        if (num.charAt(2) == 48)
                            if (num.charAt(3) == 48)
                                if (num.charAt(4) == 49)
                                    if (num.charAt(5) == 49)
                                        if (num.charAt(6) == 49)
                                            if (num.charAt(7) == 49)
                                                if (num.charAt(8) == 48)
                                                    //if (num.charAt(9) == 49)
                                                        System.out.println(num);
            }
            
        //oxygen = 001100001000 = 776
        //CO2 = 110011110011 = 3315
        
        System.out.println("O2 x CO2 = " + (776 * 3315));*/
    }
}
