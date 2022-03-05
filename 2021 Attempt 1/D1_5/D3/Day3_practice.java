package D1_5.D3;

import java.util.*;
import java.io.*;

public class Day3_practice
{
    public static void main (String[] args) throws IOException
    {
        //------------------- Part 1 -------------------//
        Scanner scanfile = new Scanner(new File("texts/D3.txt"));
        ArrayList<String> list = new ArrayList<String>();

        while (scanfile.hasNext())
        {
            list.add(scanfile.nextLine());
        }

        int sum = 0;
        int[] nums = new int[12];

        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < list.size(); j++)
                sum += Integer.parseInt(list.get(j).substring(i, i+1));

            if (sum > 500)
                sum = 1;
            else
                sum = 0;
            
            nums[i] = sum;
            sum = 0;
        }

        String gam = "";
        String eps = "";

        for (int i = 0; i < nums.length; i++)
        {
            gam += nums[i];
            eps += (1 - nums[i]);
        }
        int gamma_rate = Integer.parseInt(gam, 2);
        int epsilon_rate = Integer.parseInt(eps, 2);

        System.out.println("Part 1 Answer: " + (gamma_rate * epsilon_rate));

        //------------------- Part 2 -------------------//
        
        //For the Oxygen Generator Rating
        Scanner scanfile2 = new Scanner(new File("texts/D3.txt"));
        ArrayList<String> list2 = new ArrayList<String>();

        while (scanfile2.hasNext())
        {
            list2.add(scanfile2.nextLine());
        }
        
        int sum2 = 0;

        for(int i = 0; list2.size() > 1; i++)
        {
            for (int j = 0; j < list2.size(); j++)
            {
                sum2 += Integer.parseInt(list2.get(j).substring(i, i+1));
            }
            if (sum2 >= (list2.size()/2.0))
            {
                sum2 = 1;
            }
            else
            {
                sum2 = 0;
            }

            for (int j = 0; j < list2.size(); j++)
            {
                if (list2.get(j).substring(i, i+1).equals(Integer.toString(1 - sum2)))
                {
                    list2.remove(j);
                    j--;
                }
            }
            sum2 = 0;
        }
        
        int oxygen_gen = Integer.parseInt(list2.get(0), 2);

        
        //For the CO2 Scrubber Rating
        Scanner scanfile3 = new Scanner(new File("texts/D3.txt"));
        ArrayList<String> list3 = new ArrayList<String>();

        while (scanfile3.hasNext())
        {
            list3.add(scanfile3.nextLine());
        }
        
        int sum3 = 0;

        for(int i = 0; list3.size() > 1; i++)
        {
            for (int j = 0; j < list3.size(); j++)
            {
                sum3 += Integer.parseInt(list3.get(j).substring(i, i+1));
            }
            if (sum3 < (list3.size()/2.0))
            {
                sum3 = 1;
            }
            else
            {
                sum3 = 0;
            }

            for (int j = 0; j < list3.size(); j++)
            {
                if (list3.get(j).substring(i, i+1).equals(Integer.toString(1 - sum3)))
                {
                    list3.remove(j);
                    j--;
                }
            }
            sum3 = 0;
        }

        int CO2_scrub = Integer.parseInt(list3.get(0), 2);

        System.out.println("Part 2 Answer: " + (oxygen_gen * CO2_scrub));
    }
}
