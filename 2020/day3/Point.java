package day3;

public class Point {
    public int x;
    public int y;
    
    public Point() {
        x = 0;
        y = 0;
    }

    public void increment(int value) {
        if (value == 1) {
            x += 1;
            y += 1;
        }
        if (value == 2) {
            x += 3;
            y += 1;
        }
        if (value == 3) {
            x += 5;
            y += 1;
        }
        if (value == 4) {
            x += 7;
            y += 1;
        }
        if (value == 5) {
            x += 1;
            y += 2;
        }
    }

    public void decrement(int value) {
        x -= value;
    }

    public String toString() {
        return "X Position: " + x + " Y Position: " + y;
    }
}
