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
                Packet pack = new Packet(inputs.get(i));
                leftInput.add(pack);
            } else if (i % 3 == 1) {
                Packet pack = new Packet(inputs.get(i));
                rightInput.add(pack);
            }
        }
        
        int sumIndices = 0;
		
        for (int i = 0; i < leftInput.size(); i++) {
            sumIndices += (leftInput.get(i).compareTo(rightInput.get(i)) > 0) ? i + 1 : 0;
        }
        
        System.out.println("Part 1 Answer: " + sumIndices);

        //-----------part 2----------
        ArrayList<Packet> fullSort = new ArrayList<>();
        fullSort.add(new Packet("[[2]]"));
        fullSort.add(new Packet("[[6]]"));

        int productIndices = 1;

        while(leftInput.size() != 0) {
            fullSort.add(leftInput.remove(0));
            fullSort.add(rightInput.remove(0));
        }

        Collections.sort(fullSort);
        Collections.reverse(fullSort);

        for (int i = 0; i < fullSort.size(); i++) {
            if (fullSort.get(i).str.equals("[[2]]") || fullSort.get(i).str.equals("[[6]]")) {
                productIndices *= (i + 1);
            }
        }
        
        System.out.println("Part 2 Answer: " + productIndices);
	}
}