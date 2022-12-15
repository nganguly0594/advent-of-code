package day13;

/**
 * day13
 */

import java.io.*;
import java.util.*;

public class day13 {
	public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day13/input.txt"));

        ArrayList<String> inputs = new ArrayList<>();

        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        // ----------part 1----------
        ArrayList<Packet> leftInput = new ArrayList<>();
        ArrayList<Packet> rightInput = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            if (i % 3 == 0) {
                leftInput.add(new Packet(inputs.get(i)));
            } else if (i % 3 == 1) {
                rightInput.add(new Packet(inputs.get(i)));
            }
        }
        
        int sumIndices = 0;
		
        for (int i = 0; i < leftInput.size(); i++) {
            sumIndices += (leftInput.get(i).compare(rightInput.get(i)) > 0) ? i + 1 : 0;
        }
        
        System.out.println("Part 1 Answer: " + sumIndices);

        //-----------part 2----------
        ArrayList<Packet> fullSort = new ArrayList<>();
        fullSort.add(new Packet("[[2]]"));
        fullSort.add(new Packet("[[6]]"));

        int productIndices = 1;
        
        while(leftInput.size() != 0) {
            Packet current = leftInput.remove(0);
            Packet current2 = rightInput.remove(0);
            int i = 0;

            while (current.compare(fullSort.get(i)) == 1 && i < fullSort.size()) {
                i++;
            }
            fullSort.add(i, current);

            i = 0;
            while (current2.compare(fullSort.get(i)) == 1 && i < fullSort.size()) {
                i++;
            }
            fullSort.add(i, current2);
        }

        for (int i = 0; i < fullSort.size(); i++) {
            if (fullSort.get(i).str.equals("[[2]]") || fullSort.get(i).str.equals("[[6]]")) {
                productIndices *= (i + 1);
            }
        }
        
        System.out.println("Part 2 Answer: " + productIndices);
	}
}