package D1_5.D4;


/**
 * Write a description of class P1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.Scanner;

public class P2
{
    public static void main (String[] args) throws IOException
        {
            String numbers = "59 91 13 82 8 32 74 96 55 51 19 47 46 44 5 21 95 71 48 60 68 81 " + 
                             "80 14 23 28 26 78 12 22 49 1 83 88 39 53 84 37 93 24 42 7 56 20 " + 
                             "92 90 25 36 34 52 27 50 85 75 89 63 33 4 66 17 98 57 3 9 54 0 94 " + 
                             "29 79 61 45 86 16 30 77 76 6 38 70 62 72 43 69 35 18 97 73 41 40 " + 
                             "64 67 31 58 11 15 87 65 2 10 99";
            
            boolean thing = true;
            int counter = 0;
            int highest = 0;
            int pick = 0, final_pick = 0;
            int board_number = 0;
            Bingo board2 = new Bingo(0);
                             
            for (int count = 0; count<100; count++)
                {
                    Bingo board = new Bingo(count);
                    Scanner in = new Scanner(numbers);
                    
                    while (thing)
                        {
                            pick = in.nextInt();
                            
                            if (pick == Bingo.a)
                                {
                                    board.seta(100);
                                }
                            if (pick == Bingo.b)
                                {
                                    board.setb(100);
                                }
                            if (pick == Bingo.c)
                                {
                                    board.setc(100);
                                }
                            if (pick == Bingo.d)
                                {
                                    board.setd(100);
                                }
                            if (pick == Bingo.e)
                                {
                                    board.sete(100);
                                }
                            if (pick == Bingo.f)
                                {
                                    board.setf(100);
                                }
                            if (pick == Bingo.g)
                                {
                                    board.setg(100);
                                }
                            if (pick == Bingo.h)
                                {
                                    board.seth(100);
                                }
                            if (pick == Bingo.i)
                                {
                                    board.seti(100);
                                }
                            if (pick == Bingo.j)
                                {
                                    board.setj(100);
                                }
                            if (pick == Bingo.k)
                                {
                                    board.setk(100);
                                }
                            if (pick == Bingo.l)
                                {
                                    board.setl(100);
                                }
                            if (pick == Bingo.m)
                                {
                                    board.setm(100);
                                }
                            if (pick == Bingo.n)
                                {
                                    board.setn(100);
                                }
                            if (pick == Bingo.o)
                                {
                                    board.seto(100);
                                }
                            if (pick == Bingo.p)
                                {
                                    board.setp(100);
                                }
                            if (pick == Bingo.q)
                                {
                                    board.setq(100);
                                }
                            if (pick == Bingo.r)
                                {
                                    board.setr(100);
                                }
                            if (pick == Bingo.s)
                                {
                                    board.sets(100);
                                }
                            if (pick == Bingo.t)
                                {
                                    board.sett(100);
                                }
                            if (pick == Bingo.u)
                                {
                                    board.setu(100);
                                }
                            if (pick == Bingo.v)
                                {
                                    board.setv(100);
                                }
                            if (pick == Bingo.w)
                                {
                                    board.setw(100);
                                }
                            if (pick == Bingo.x)
                                {
                                    board.setx(100);
                                }
                            if (pick == Bingo.y)
                                {
                                    board.sety(100);
                                }
                            
                            counter++;
                                
                            if (board.win())
                                {
                                    thing = false;
                                }
                        }
                    
                    if (counter > highest)
                        {
                            highest = counter;
                            board2 = board;
                            final_pick = pick;
                            board_number = count + 1;
                            System.out.println(board2);
                        }
                    thing = true;
                    counter = 0;
                }
            
            System.out.println(final_pick);
            System.out.println();
            System.out.println(board_number);
        }
}
