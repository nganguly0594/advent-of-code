package D1_5.D5;


/**
 * Write a description of class P1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.Scanner;

public class P1_1
{
    public static void main (String[] args) throws IOException
        {
            Scanner scanfile = new Scanner(new File("texts/D5.txt"));
            
            while (scanfile.hasNext())
                {
                    String line = scanfile.nextLine();
                    String line2 = line.replace(",", " ");
                    
                    /*
                    int x1 = scanfile.nextInt();
                    int y1 = scanfile.nextInt();
                    scanfile.next();
                    int x2 = scanfile.nextInt();
                    int y2 = scanfile.nextInt();
                    
                    if (x1 == x2)
                        {
                             System.out.println("" + x1 + " " + y1 + " -> " + x2 + " " + y2);   
                        }
                        */
                }
            
            int[][] map = new int[1000][1000];
            
            for (int point[] : map)
                
            
            for (int row = 0; row < map.length; row++)
                {
                    for (int column = 0; column < map[row].length; column++)
                        {
                            
                        }
                }
        }
}
