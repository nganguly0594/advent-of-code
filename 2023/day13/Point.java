package day13;

public class Point {
    int row;
    int col;
    char data;

    public Point(int r, int c, char d) {
        row = r;
        col = c;
        data = d;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
