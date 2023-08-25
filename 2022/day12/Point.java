package day12; 

public class Point {
    public int row;
    public int col;
    public Point prev;
    public char val;
    public int distance;

    public Point(int r, int c, char v, int dist) {
        row = r;
        col = c;
        prev = null;
        val = v;
        distance = dist;
    }

    public String toString() {
        return "Row: " + row + " Col: " + col;
    }
}
