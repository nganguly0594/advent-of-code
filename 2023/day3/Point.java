package day3;

public class Point {
    int row;
    int col;

    public Point(int r, int c) {
        row = r;
        col = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } 
        else if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return this.row == p.row && this.col == p.col;
    }

    @Override
    public int hashCode() {
        int prime = 1009;
        int result = 1;
        result = prime * result + row;
        result = prime * result + col;
        return result;
    }
}
