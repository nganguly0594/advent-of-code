package D6_10.D8; 

import java.util.*;
import java.io.*;

public class P1
{
    public static void main (String[] args) throws IOException
    {
        Scanner scanfile = new Scanner(new File("texts/D8.txt"));
        
        int count = 0;
        for (int i = 0; i < 200; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                scanfile.next();
            }
            
            for (int j = 0; j < 4; j++)
            {
                int length = scanfile.next().length();
                if (length == 2 || length == 3 || length == 4 || length == 7)
                    count++;
            }
        }
        System.out.println("Part 1: " + (count));
    }
}
