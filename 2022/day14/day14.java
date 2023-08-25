package day14;

/**
 * day14 
 */

import java.io.*;
import java.util.*;

public class day14 {
    public static int lowest;

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day14/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        boolean[][] grid = new boolean[1000][1000];
        boolean[][] grid2 = new boolean[1000][1000];

        //----------part 1----------
        lowest = 0;
        
        for (int i = 0; i < inputs.size(); i++) {
            lowest = Math.max(addWall(inputs.get(i), grid), lowest);
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid2[r][c] = grid[r][c];
            }
        }

        int sandCount = 0;

        while(sand(grid)) {
            sandCount++;
        }
        
        System.out.println("Part 1 Answer: " + sandCount);


        //----------part 2----------
        sandCount = 0;

        addWall("0," + (lowest + 2) + " -> 999," + (lowest + 2), grid2);

        while(sand(grid2)) {
            sandCount++;
        }

        System.out.println("Part 2 Answer: " + sandCount);
    }

    public static boolean sand(boolean[][] g) {
        if (g[500][0]) {
            return false;
        }
        int x = 500;
		int y = 0;
		while (y <= lowest + 3) {
			if (!g[x][y + 1]) {
				y++;
				continue;
			}
			if (!g[x - 1][y + 1]) {
				y++;
				x--;
				continue;
			}
			if (!g[x + 1][y + 1]) {
				y++;
				x++;
				continue;
			}
			g[x][y] = true;
			return true;
		}
		return false;
    }

    public static int addWall(String wall, boolean[][] g) {
        int max = -1000;
		String[] parts = wall.split(" -> ");
		for (int i = 1; i < parts.length; i++) {
			int x1 = Integer.parseInt(parts[i - 1].split(",")[0]);
			int y1 = Integer.parseInt(parts[i - 1].split(",")[1]);
			int x2 = Integer.parseInt(parts[i].split(",")[0]);
			int y2 = Integer.parseInt(parts[i].split(",")[1]);
			for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
				for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
					g[j][k] = true;
				}
			}
			max = Math.max(max, Math.max(y1, y2));
		}
		return max;
    }
}