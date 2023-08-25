package D1_5.D5; 


/**
 * Write a description of class P1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.Scanner;

public class P1
{
    public static void main (String[] args) throws IOException
        {
            Scanner scanfile = new Scanner(new File("texts/D5.txt"));
            
            int[][] table = new int[1000][1000];
            for (int row = 0; row < table.length; row++)
                {
                    for (int column = 0; column < table[row].length; column++)
                        {
                            table[row][column] = 0;
                        }
                }
            
            while (scanfile.hasNext())
                {
                    String line = scanfile.nextLine();
                    String line2 = line.replace(",", " ");
                    
                    Scanner input = new Scanner(line2);
                    
                    int x1 = input.nextInt();
                    int y1 = input.nextInt();
                    input.next();
                    int x2 = input.nextInt();
                    int y2 = input.nextInt();
                    
                    if (x1 == x2)
                        {
                            int ylow = 0;
                            int yhigh = 0;
                            
                            if (y1 < y2)
                                 {
                                     ylow = y1;
                                     yhigh = y2;
                                 }
                            else
                                 {
                                     ylow = y2;
                                     yhigh = y1;
                                 }
                            
                            for (int row = ylow; row <= yhigh; row++)
                                 {
                                     for (int column = x1; column <= x2; column++)
                                         {
                                             table[row][column]++;
                                         }
                                 }
                            
                        }
                    
                    else if (y1 == y2)
                        {
                            int xlow = 0;
                            int xhigh = 0;
                            
                            if (x1 < x2)
                                 {
                                     xlow = x1;
                                     xhigh = x2;
                                 }
                            else
                                 {
                                     xlow = x2;
                                     xhigh = x1;
                                 }
                            
                            for (int column = xlow; column <= xhigh; column++)
                                 {
                                     for (int row = y1; row <= y2; row++)
                                         {
                                             table[row][column]++;
                                         }
                                 }
                        }
                }
            
            int count = 0;
            for (int row = 0; row < table.length; row++)
                {
                    for (int column = 0; column < table[row].length; column++)
                        {
                            if (table[row][column] >= 2)
                                {
                                    count++;
                                }
                        }
                }
            
            System.out.println(count);
        }
}
