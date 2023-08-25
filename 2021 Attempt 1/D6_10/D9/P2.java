package D6_10.D9; 


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
        Scanner scanfile = new Scanner(new File("texts/D9.txt"));
        String[][] height = new String[100][100];
        
        for (int row = 0; row < height.length; row++)
        {
            String line = scanfile.nextLine();
            for (int column = 0; column < height[row].length; column++)
            {
                height[row][column] = line.substring(column, column + 1);
            }
        }
    }
}
