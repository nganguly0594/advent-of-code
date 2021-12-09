package D6_10.D9;

import java.util.Scanner;
import java.io.*;

public class P1
{
    public static void main (String[] args) throws IOException
    {
        Scanner scanfile = new Scanner(new File("texts/D9.txt"));
        int[][] height = new int[100][100];
        int risk_level = 0;

        for (int row = 0; row < height.length; row++)
        {
            String line = scanfile.nextLine();
            for (int column = 0; column < height[row].length; column++)
            {
                height[row][column] = Integer.parseInt(line.substring(column, column + 1));
            }
        }
        int num1 = height[0][0];
        int num2 = height[99][0];
        int num3 = height[0][99];
        int num4 = height[99][99];

        if (num1 < height[0][1] && num1 < height[1][0])
            risk_level += num1 + 1;
        if (num2 < height[99][1] && num2 < height[98][0])
            risk_level += num2 + 1;
        if (num3 < height[0][98] && num3 < height[1][99])
            risk_level += num3 + 1;
        if (num4 < height[99][98] && num4 < height[98][99])
            risk_level += num4 + 1;
        
        for (int column = 1; column < height[0].length - 1; column++)
        {
            int num = height[0][column];
            if (num < height[0][column - 1] && num < height[0][column + 1] && num < height[1][column])
                risk_level += num + 1;
        }

        for (int column = 1; column < height[99].length - 1; column++)
        {
            int num = height[99][column];
            if (num < height[99][column - 1] && num < height[99][column + 1] && num < height[98][column])
                risk_level += num + 1;
        }

        for (int row = 1; row < height.length - 1; row++)
        {
            int num = height[row][0];
            if (num < height[row - 1][0] && num < height[row + 1][0] && num < height[row][1])
                risk_level += num + 1;
        }

        for (int row = 1; row < height.length - 1; row++)
        {
            int num = height[row][99];
            if (num < height[row - 1][99] && num < height[row + 1][99] && num < height[row][98])
                risk_level += num + 1;
        }

        for (int row = 1; row < height.length - 1; row++)
        {
            for (int column = 1; column < height[row].length - 1; column++)
            {
                int num = height[row][column];
                if (num < height[row - 1][column] && num < height[row + 1][column] && num < height[row][column - 1] && num < height[row][column + 1])
                    risk_level += num + 1;
            }
        }
        System.out.println(risk_level);
    }
}
