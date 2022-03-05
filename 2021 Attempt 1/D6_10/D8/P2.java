package D6_10.D8;

import java.util.*;
import java.io.*;

public class P2
{
    public static void main (String[] args) throws IOException
    {
        Scanner scanfile = new Scanner(new File("texts/D8.txt"));

        int sum = 0;
        String a = "", b = "", c = "", d = "", e = "", f = "", g = "";
        String output = "";

        for (int i = 0; i < 200; i++)
        {
            String line = scanfile.nextLine();

            Scanner scan1 = new Scanner(line);
            boolean bool = true;
            while (bool)
            {
                String word = scan1.next();
                int length = word.length();
                if (length == 2)
                {
                    c = word.substring(0, 1);
                    f = word.substring(1, 2);
                    bool = false;
                }
            }

            Scanner scan2 = new Scanner(line);
            bool = true;
            while(bool)
            {
                String word = scan2.next();
                int length = word.length();
                if (length == 3)
                {
                    String first = word.substring(0, 1);
                    String second = word.substring(1, 2);
                    String third = word.substring(2, 3);

                    if (!first.equals(c) && !first.equals(f))
                    {
                        a = first;
                    }
                    else if (!second.equals(c) && !second.equals(f))
                    {
                        a = second;
                    }
                    else if (!third.equals(c) && !third.equals(f))
                    {
                        a = third;
                    }
                    bool = false;
                }
            }

            bool = true;
            int count = 0;
            Scanner scan3 = new Scanner(line);
            while(bool)
            {
                String word = scan3.next();
                int length = word.length();
                if (length == 6)
                {
                    String first = word.substring(0, 1);
                    String second = word.substring(1, 2);
                    String third = word.substring(2, 3);
                    String fourth = word.substring(3, 4);
                    String fifth = word.substring(4, 5);
                    String sixth = word.substring(5, 6);

                    if (!first.equals(f) && !second.equals(f) && !third.equals(f) && !fourth.equals(f) &&  !fifth.equals(f) && !sixth.equals(f))
                    {
                        String stuff = c;
                        c = f;
                        f = stuff;
                    }
                    
                    count++;
                }

                if (count > 2)
                {
                    bool = false;
                }
            }

            Scanner scan4 = new Scanner(line);
            bool = true;
            while(bool)
            {
                String word = scan4.next();
                int length = word.length();
                if (length == 4)
                {
                    String first = word.substring(0, 1);
                    String second = word.substring(1, 2);
                    String third = word.substring(2, 3);
                    String fourth = word.substring(3, 4);

                    if (!first.equals(c) && !first.equals(f) && !second.equals(c) && !second.equals(f)) 
                    {
                        b = first;
                        d = second;
                    }
                    else if (!first.equals(c) && !first.equals(f) && !third.equals(c) && !third.equals(f))
                    {
                        b = first;
                        d = third;
                    }
                    else if (!first.equals(c) && !first.equals(f) && !fourth.equals(c) && !fourth.equals(f))
                    {
                        b = first;
                        d = fourth;
                    }
                    else if (!second.equals(c) && !second.equals(f) && !third.equals(c) && !third.equals(f))
                    {
                        b = second;
                        d = third;
                    }
                    else if (!second.equals(c) && !second.equals(f) && !fourth.equals(c) && !fourth.equals(f))
                    {
                        b = second;
                        d = fourth;
                    }
                    else if (!third.equals(c) && !third.equals(f) && !fourth.equals(c) && !fourth.equals(f))
                    {
                        b = third;
                        d = fourth;
                    }
                    bool = false;
                }
            }

            Scanner scan5 = new Scanner(line);
            bool = true;
            while(bool)
            {
                String word = scan5.next();
                int length = word.length();
                if (length == 6)
                {
                    String first = word.substring(0, 1);
                    String second = word.substring(1, 2);
                    String third = word.substring(2, 3);
                    String fourth = word.substring(3, 4);
                    String fifth = word.substring(4, 5);
                    String sixth = word.substring(5, 6);

                    if (!first.equals(c) && !second.equals(c) && !third.equals(c) && !fourth.equals(c) && !fifth.equals(c) && !sixth.equals(c))
                    {
                        bool = true;
                    }
                    else if ((first.equals(b) || second.equals(b) || third.equals(b) || fourth.equals(b) || fifth.equals(b) || sixth.equals(b)) &&
                             (first.equals(d) || second.equals(d) || third.equals(d) || fourth.equals(d) || fifth.equals(d) || sixth.equals(d)))
                    {
                        bool = true;
                    }
                    else
                    {
                        if (first.equals(b) || second.equals(b) || third.equals(b) || fourth.equals(b) || fifth.equals(b) || sixth.equals(b))
                        {
                            b = b;
                            d = d;
                        }
                        else
                        {
                            String stuff = d;
                            d = b;
                            b = stuff;
                        }
                        bool = false;
                    }
                }
            }

            Scanner scan6 = new Scanner(line);
            bool = true;
            while(bool)
            {
                String word = scan6.next();
                int length = word.length();
                if (length == 6)
                {
                    String first = word.substring(0, 1);
                    String second = word.substring(1, 2);
                    String third = word.substring(2, 3);
                    String fourth = word.substring(3, 4);
                    String fifth = word.substring(4, 5);
                    String sixth = word.substring(5, 6);
                    
                    if (!first.equals(c) && !second.equals(c) && !third.equals(c) && !fourth.equals(c) && !fifth.equals(c) && !sixth.equals(c))
                    {
                        bool = true;
                    }
                    else if (first.equals(d) || second.equals(d) || third.equals(d) || fourth.equals(d) || fifth.equals(d) || sixth.equals(d))
                    {
                        if (!first.equals(a) && !first.equals(b) && !first.equals(d) && !first.equals(c) && !first.equals(f))
                        {
                            g = first;
                        }
                        else if (!second.equals(a) && !second.equals(b) && !second.equals(d) && !second.equals(c) && !second.equals(f))
                        {
                            g = second;
                        }
                        else if (!third.equals(a) && !third.equals(b) && !third.equals(d) && !third.equals(c) && !third.equals(f))
                        {
                            g = third;
                        }
                        else if (!fourth.equals(a) && !fourth.equals(b) && !fourth.equals(d) && !fourth.equals(c) && !fourth.equals(f))
                        {
                            g = fourth;
                        }
                        else if (!fifth.equals(a) && !fifth.equals(b) && !fifth.equals(d) && !fifth.equals(c) && !fifth.equals(f))
                        {
                            g = fifth;
                        }
                        else if (!sixth.equals(a) && !sixth.equals(b) && !sixth.equals(d) && !sixth.equals(c) && !sixth.equals(f))
                        {
                            g = sixth;
                        }
                        bool = false;
                    }
                    else 
                    {
                        bool = true;
                    }
                }
            }

            Scanner scan7 = new Scanner(line);
            bool = true;
            while(bool)
            {
                String word = scan7.next();
                int length = word.length();
                if (length == 7)
                {
                    String first = word.substring(0, 1);
                    String second = word.substring(1, 2);
                    String third = word.substring(2, 3);
                    String fourth = word.substring(3, 4);
                    String fifth = word.substring(4, 5);
                    String sixth = word.substring(5, 6);
                    String seventh = word.substring(6, 7);
                  
                    if (!first.equals(a) && !first.equals(b) && !first.equals(d) && !first.equals(c) && !first.equals(f) && !first.equals(g))
                    {
                        e = first;
                    }
                    else if (!second.equals(a) && !second.equals(b) && !second.equals(d) && !second.equals(c) && !second.equals(f) && !second.equals(g))
                    {
                        e = second;
                    }
                    else if (!third.equals(a) && !third.equals(b) && !third.equals(d) && !third.equals(c) && !third.equals(f) && !third.equals(g))
                    {
                        e = third;
                    }
                    else if (!fourth.equals(a) && !fourth.equals(b) && !fourth.equals(d) && !fourth.equals(c) && !fourth.equals(f) && !fourth.equals(g))
                    {
                        e = fourth;
                    }
                    else if (!fifth.equals(a) && !fifth.equals(b) && !fifth.equals(d) && !fifth.equals(c) && !fifth.equals(f) && !fifth.equals(g))
                    {
                        e = fifth;
                    }
                    else if (!sixth.equals(a) && !sixth.equals(b) && !sixth.equals(d) && !sixth.equals(c) && !sixth.equals(f) && !sixth.equals(g))
                    {
                        e = sixth;
                    }
                    else if (!seventh.equals(a) && !seventh.equals(b) && !seventh.equals(d) && !seventh.equals(c) && !seventh.equals(f) && !seventh.equals(g))
                    {
                        e = seventh;
                    }
                    bool = false;
            
                }
            }

            Scanner scan8 = new Scanner(line);

            for (int k = 0; k < 11; k++)
            {
                scan8.next();
            }
            
            for (int k = 0; k < 4; k++)
            {
                String word2 = scan8.next();
                int len = word2.length();
                if (len == 2)
                    output += "1";
                else if (len == 3)
                    output += "7";
                else if (len == 4)
                    output += "4";
                else if (len == 5)
                {
                    String one = word2.substring(0, 1);
                    String two = word2.substring(1, 2);
                    String three = word2.substring(2, 3);
                    String four = word2.substring(3, 4);
                    String five = word2.substring(4, 5);
                    if (one.equals(c) || two.equals(c) || three.equals(c) || four.equals(c) || five.equals(c))
                    {
                        if (one.equals(e) || two.equals(e) || three.equals(e) || four.equals(e) || five.equals(e))
                            output += "2";
                        else
                            output += "3";
                    }    
                    else
                        output += "5";

                }
                else if (len == 6)
                {
                    String one = word2.substring(0, 1);
                    String two = word2.substring(1, 2);
                    String three = word2.substring(2, 3);
                    String four = word2.substring(3, 4);
                    String five = word2.substring(4, 5);
                    String six = word2.substring(5, 6);
                    if (one.equals(c) || two.equals(c) || three.equals(c) || four.equals(c) || five.equals(c) || six.equals(c))
                    {
                        if (one.equals(e) || two.equals(e) || three.equals(e) || four.equals(e) || five.equals(e) || six.equals(e))
                            output += "0";
                        else
                            output += "9";
                    }    
                    else
                        output += "6";
                }
                else if (len == 7)
                    output += "8";

            }

            sum += Integer.parseInt(output);
            output = "";
        }

        System.out.println("Part 2 Answer: " + sum);
    }
}
