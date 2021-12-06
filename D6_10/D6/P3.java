package D6_10.D6;


/**
 * Write a description of class P3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.io.*;

public class P3
{
    public static void main (String[] args) throws IOException
        {
            Scanner scanfile = new Scanner(new File("texts/D6.txt"));
            
            String input = scanfile.nextLine().replace(",", " ");
            
            Scanner scan = new Scanner(input);
            
            long[] lanternfish = new long[9];
            
            while (scanfile.hasNext())
                {
                    if (scanfile.nextInt() == 0)
                        {
                            lanternfish[0]++;
                        }
                    if (scanfile.nextInt() == 1)
                        {
                            lanternfish[1]++;
                        }
                    if (scanfile.nextInt() == 2)
                        {
                            lanternfish[2]++;
                        }
                    if (scanfile.nextInt() == 3)
                        {
                            lanternfish[3]++;
                        }
                    if (scanfile.nextInt() == 4)
                        {
                            lanternfish[4]++;
                        }
                    if (scanfile.nextInt() == 5)
                        {
                            lanternfish[5]++;
                        }
                    if (scanfile.nextInt() == 6)
                        {
                            lanternfish[6]++;
                        }
                    if (scanfile.nextInt() == 7)
                        {
                            lanternfish[7]++;
                        }
                    if (scanfile.nextInt() == 8)
                        {
                            lanternfish[8]++;
                        }
                }
                
            
        }
}
