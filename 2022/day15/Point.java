package day15;

public class Point {
    public int row;
    public int col;

    public Point(int r, int c) {
        row = r;
        col = c;
    }

    @Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (o.getClass() != this.getClass()) {
			return false;
		}
		
        Point p = (Point) o;
		return p.row == this.row && p.col == this.col;
	}

    public String toString() {
        return "Row: " + row + " Col: " + col;
    }
}
