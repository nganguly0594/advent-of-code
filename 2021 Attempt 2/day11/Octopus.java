package day11;

/**
 * Point
 */
public class Octopus {
    public int row;
    public int col;

    public Octopus(int r, int c) {
        row = r;
        col = c;
    }

    public String toString() {
        return "row: " + row + " col: " + col;
    }
}