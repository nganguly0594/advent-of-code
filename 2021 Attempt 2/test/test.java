package test;

import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("test/testinput.txt"));
        
        int[][] riskMap = new int[10][10];
        for (int y = 0; y < riskMap.length; y++) {
            String line = scanfile.nextLine();
            for (int x = 0; x < riskMap[0].length; x++) {
                riskMap[y][x] = line.charAt(x) - '0';
            }
        }

        // SHORTEST cost to go from every node to bottom-right corner
		int[][] riskSums = new int[riskMap.length][riskMap[0].length];
		
		// Initialize each path to bottom-right corner as 1000000 (for future min comparison)
		Arrays.stream(riskSums).forEach(row -> Arrays.fill(row, 1_000_000));
		
		// Initialize bottom-right corner as 0 (path to it equals to 0)
		riskSums[riskSums.length - 1][riskSums[0].length - 1] = 0;

        /*for (int y = 0; y < riskMap.length; y++) {
            for (int x = 0; x < riskMap[0].length; x++) {
                System.out.print(riskSums[y][x] + " ");
            }
            System.out.println();
        }*/
		
		boolean changeMade = true;
		
        int count = 0;
		while (changeMade) {
			changeMade = false;
			for (int r = riskSums.length - 1; r >= 0; --r) {
				for (int c = riskSums[0].length - 1; c >= 0; --c) {
					// Four neighbours:
					// riskMap[r][c] : risk to enter this particular node
					// riskSums[r][c] : currently lowest risk to travel from this node to bottom-right corner
					count++;

					int min = Integer.MAX_VALUE;
					
					if (r - 1 >= 0) {
						min = Math.min(min, riskMap[r - 1][c] + riskSums[r - 1][c]);
					}
					
					if (r + 1 < riskSums.length) {
						min = Math.min(min, riskMap[r + 1][c] + riskSums[r + 1][c]);
					}
					
					if (c - 1 >= 0) {
						min = Math.min(min, riskMap[r][c - 1] + riskSums[r][c - 1]);
					}
					
					if (c + 1 < riskSums[0].length) {
						min = Math.min(min, riskMap[r][c + 1] + riskSums[r][c + 1]);
					}
					
					// Check if change must be made
					int oldRisk = riskSums[r][c];
					riskSums[r][c] = Math.min(min, riskSums[r][c]);
					if (oldRisk != riskSums[r][c]) {
						changeMade = true;
					}

                    if (count < 20) {
                        for (int y = 0; y < riskMap.length; y++) {
                            for (int x = 0; x < riskMap[0].length; x++) {
                                System.out.print(riskSums[y][x] + " ");
                            }
                            System.out.println();
                        }
                        System.out.println("\n\n");
                    }
				}
			}
		}
		
		System.out.println(riskSums[0][0]);
    }
}
