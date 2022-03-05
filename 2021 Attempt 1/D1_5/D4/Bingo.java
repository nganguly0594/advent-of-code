package D1_5.D4;


/**
 * Write a description of class P1helper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.Scanner;

public class Bingo
{
    public static int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y;
    
        
    /**
     * Constructor thingie
     */
    public Bingo (int board) throws IOException
        {
            Scanner scanfile = new Scanner(new File("texts/D4.txt"));
            
            int z = 0;
            
            while (z < (board*25))
                {
                    scanfile.nextInt();
                    z++;
                }
            
            
            a = scanfile.nextInt();
            b = scanfile.nextInt();
            c = scanfile.nextInt();
            d = scanfile.nextInt();
            e = scanfile.nextInt();
            f = scanfile.nextInt();
            g = scanfile.nextInt();
            h = scanfile.nextInt();
            i = scanfile.nextInt();
            j = scanfile.nextInt();
            k = scanfile.nextInt();
            l = scanfile.nextInt();
            m = scanfile.nextInt();
            n = scanfile.nextInt();
            o = scanfile.nextInt();
            p = scanfile.nextInt();
            q = scanfile.nextInt();
            r = scanfile.nextInt();
            s = scanfile.nextInt();
            t = scanfile.nextInt();
            u = scanfile.nextInt();
            v = scanfile.nextInt();
            w = scanfile.nextInt();
            x = scanfile.nextInt();
            y = scanfile.nextInt();
        }
    
    
    /**
     * checks if win yet or not
     */
    public boolean win ()
        {
            boolean bool = false;
            
            if (a == 100 && b == 100 && c == 100 && d == 100 && e == 100)
                bool = true;
            if (f == 100 && g == 100 && h == 100 && i == 100 && j == 100)
                bool = true;
            if (k == 100 && l == 100 && m == 100 && n == 100 && o == 100)
                bool = true;
            if (p == 100 && q == 100 && r == 100 && s == 100 && t == 100)
                bool = true;
            if (u == 100 && v == 100 && w == 100 && x == 100 && y == 100)
                bool = true;
            
            if (a == 100 && f == 100 && k == 100 && p == 100 && u == 100)
                bool = true;
            if (b == 100 && g == 100 && l == 100 && q == 100 && v == 100)
                bool = true;
            if (c == 100 && h == 100 && m == 100 && r == 100 && w == 100)
                bool = true;
            if (d == 100 && i == 100 && n == 100 && s == 100 && x == 100)
                bool = true;
            if (e == 100 && j == 100 && o == 100 && t == 100 && y == 100)
                bool = true;
            
            return bool;
        }
    
    
    
    public void seta(int num)
       {
           this.a = num;
       
       }
    public void setb(int num)
       {
           this.b = num;
       
       }
    public void setc(int num)
       {
           this.c = num;
       
       }
    public void setd(int num)
       {
           this.d = num;
       
       }
    public void sete(int num)
       {
           this.e = num;
       
       }
    public void setf(int num)
       {
           this.f = num;
       
       }
    public void setg(int num)
       {
           this.g = num;
       
       }
    public void seth(int num)
       {
           this.h = num;
       
       }
    public void seti(int num)
       {
           this.i = num;
       
       }
    public void setj(int num)
       {
           this.j = num;
       
       }
    public void setk(int num)
       {
           this.k = num;
       
       }
    public void setl(int num)
       {
           this.l = num;
       
       }
    public void setm(int num)
       {
           this.m = num;
       
       }
    public void setn(int num)
       {
           this.n = num;
       
       }
    public void seto(int num)
       {
           this.o = num;
       
       }
    public void setp(int num)
       {
           this.p = num;
       
       }
    public void setq(int num)
       {
           this.q = num;
       
       }
    public void setr(int num)
       {
           this.r = num;
       
       }
    public void sets(int num)
       {
           this.s = num;
       
       }
    public void sett(int num)
       {
           this.t = num;
       
       }
    public void setu(int num)
       {
           this.u = num;
       
       }
    public void setv(int num)
       {
           this.v = num;
       
       }
    public void setw(int num)
       {
           this.w = num;
       
       }
    public void setx(int num)
       {
           this.x = num;
       
       }
    public void sety(int num)
       {
           this.y = num;
       
       }
    
       
       
    
    /**
     * string
     */
    public String toString ()
        {
            String data = a + " " + b + " " + c + " " + d + " " + e + "\n";
            data += f + " " + g + " " + h + " " + i + " " + j + "\n";
            data += k + " " + l + " " + m + " " + n + " " + o + "\n";
            data += p + " " + q + " " + r + " " + s + " " + t + "\n";
            data += u + " " + v + " " + w + " " + x + " " + y + "\n";
              
            return data;
        }
}
