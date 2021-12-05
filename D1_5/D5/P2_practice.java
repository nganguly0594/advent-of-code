package D1_5.D5;


/**
 * Write a description of class P2_practice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.Scanner;

public class P2_practice
{
    public static void main (String[] args) throws IOException
        {
            Scanner scanfile = new Scanner(new File("texts/D5.txt"));
            int[][] array = new int[1000][1000];
            
            while (scanfile.hasNext())
                {
                    String line = scanfile.nextLine();
                    String line2 = line.replace(",", " ");
                    
                    Scanner linescan = new Scanner(line2);
                    
                    int x1 = linescan.nextInt();
                    int y1 = linescan.nextInt();
                    linescan.next();
                    int x2 = linescan.nextInt();
                    int y2 = linescan.nextInt();
                    
                    if (x1 == x2)
                        {
                            if (y1 > y2)
                                {
                                    int y3 = y1;
                                    y1 = y2;
                                    y2 = y3;
                                }
                            
                            for (int row = y1; row <= y2; row++)
                                {
                                    array[row][x1]++;
                                }
                        }
                        
                    else if (y1 == y2)
                        {
                            if (x1 > x2)
                                {
                                    int x3 = x1;
                                    x1 = x2;
                                    x2 = x3;
                                }
                            
                            for (int column = x1; column <= x2; column++)
                                {
                                    array[y1][column]++;
                                }
                        }
                }
                
            int count = 0;
            for (int row = 0; row < array.length; row++)
                {
                    for (int column = 0; column < array[row].length; column++)
                        {
                            if (array[row][column] >= 2)
                                {
                                    count++;
                                }
                        }
                }
                
            System.out.println("The Answer to Part 1 is " + count + ".");
            
            //---------------------------------------------------------------------------------------------------//
            //---------------------------------------------------------------------------------------------------//
            //Part 2:
            
            Scanner scanfile2 = new Scanner(new File("texts/D5.txt"));
            int[][] array2 = new int[1000][1000];
            
            while (scanfile2.hasNext())
                {
                    String line = scanfile2.nextLine();
                    String line2 = line.replace(",", " ");
                    
                    Scanner linescan = new Scanner(line2);
                    
                    int x1 = linescan.nextInt();
                    int y1 = linescan.nextInt();
                    linescan.next();
                    int x2 = linescan.nextInt();
                    int y2 = linescan.nextInt();
                    
                    if (x1 == x2)
                        {
                            if (y1 > y2)
                                {
                                    int y3 = y1;
                                    y1 = y2;
                                    y2 = y3;
                                }
                            
                            for (int row = y1; row <= y2; row++)
                                {
                                    array2[row][x1]++;
                                }
                        }
                        
                    else if (y1 == y2)
                        {
                            if (x1 > x2)
                                {
                                    int x3 = x1;
                                    x1 = x2;
                                    x2 = x3;
                                }
                            
                            for (int column = x1; column <= x2; column++)
                                {
                                    array2[y1][column]++;
                                }
                        }
                    
                    else
                        {
                            if (x2 < x1)
                                {
                                    int x3 = x1;
                                    x1 = x2;
                                    x2 = x3;
                                    
                                    int y3 = y1;
                                    y1 = y2;
                                    y2 = y3;
                                }
                            
                            if (y1 < y2)
                                {
                                    for (int column = x1; column <= x2; column++)
                                        {
                                            array2[y1][column]++;
                                            y1++;
                                        }
                                }
                                
                            else if (y2 < y1)
                                {
                                    for (int column = x1; column <= x2; column++)
                                        {
                                            array2[y1][column]++;
                                            y1--;
                                        }
                                }
                        }
                }
                
            int count2 = 0;
            for (int row = 0; row < array2.length; row++)
                {
                    for (int column = 0; column < array2[row].length; column++)
                        {
                            if (array2[row][column] >= 2)
                                {
                                    count2++;
                                }
                        }
                }
                
            System.out.println("The Answer to Part 2 is " + count2 + ".");
        }
}
