package D1_5.D2; 


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
        Scanner scanfile = new Scanner(new File("texts/D2.txt"));
        
        int depth = 0;
        int distance = 0;
        
        while (scanfile.hasNext())
            {
                String term = scanfile.next();
                int num = Integer.parseInt(scanfile.next());
                
                if (term.equals("forward"))
                    distance += num;
                else if (term.equals("down"))
                    depth += num;
                else if (term.equals("up"))
                    depth -= num;
            }
        
        System.out.println("Forward distance is: " + distance);
        System.out.println("Depth is: " + depth);
        System.out.println("Value is: " + (depth * distance));
    }
}
