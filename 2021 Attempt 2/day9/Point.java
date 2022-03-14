package day9;

/**
 * Point
 */
public class Point {
    public int row;
    public int col;

    public Point(int r, int c) {
        row = r;
        col = c;
    }

    public String toString() {
        return "row: " + row + " col: " + col;
    }
}