package day11;

import java.util.*;

public class Monkey {
    public Queue<Long> items;
    public String operation;
    public String factor;
    public int divisible;
    public Monkey yes;
    public Monkey no;
    
    public Monkey() {
        divisible = 0;
        items = null;
        yes = null;
        no = null;
        operation = null;
        factor = null;
    }

    public void set(Queue<Long> starting, String oper, String fact, int testnum, Monkey first, Monkey second) {
        divisible = testnum;
        items = starting;
        yes = first;
        no = second;
        operation = oper;
        factor = fact;
    }

    public long turn(int product) {
        long inspections = 0;

        while (items.size() != 0) {
            inspections++;
            long worry = newWorry() / 3;
            if (worry % divisible == 0) {
                yes.items.add(worry);
            }
            else {
                no.items.add(worry);
            }
        }

        return inspections;
    }

    public long turn2(int product) {
        long inspections = 0;

        while (items.size() != 0) {
            inspections++;
            long worry = newWorry() % product;
            if (worry % divisible == 0) {
                yes.items.add(worry);
            }
            else {
                no.items.add(worry);
            }
        }

        return inspections;
    } 

    public long newWorry() {
        long num = items.remove();
        if (operation.equals("*")) {
            num = multiply(num);
        }
        else {
            num = add(num);
        }
        return num;
    }

    public long multiply(long n) {
        if (factor.equals("old")) {
            return (long) Math.pow(n, 2);
        }
        else {
            return n * Long.parseLong(factor);
        }
    }

    public long add(long n) {
        return n + Long.parseLong(factor);
    }

    public String toString() {
        String result = "Items: ";
        for (long item : items) {
            result += item + " ";
        }
        return result;
    }
}
