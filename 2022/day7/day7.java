package day7;

/**
 * day7
 */

import java.io.*;
import java.util.*;

public class day7 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day7/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.nextLine());
        }

        //----------part 1 and part 2----------
        Directory root = new Directory("/");
        Directory current = root;

        for (int i = 1; i < inputs.size(); i++) {
            String[] parts = inputs.get(i).split(" ");

            if (parts[0].equals("$")) {
                if (parts[1].equals("cd")) {
                    if (!parts[2].equals("..")) {
                        current = current.get(parts[2]);
                    }
                    else {
                        current = current.parentdir;
                    }
                }
            }
            else {
                if (parts[0].equals("dir")) {
                    Directory nod = new Directory(parts[1]);
                    nod.setParent(current);
                    current.add(nod);
                }
                else {
                    Files fil = new Files (parts[1], Integer.parseInt(parts[0]));
                    current.add(fil);
                }
            }
        }

        int sum = 0;
        int spaceNeeded = 30000000 - (70000000 - root.sizeCount());
        int minDirectory = Integer.MAX_VALUE;

        Queue<Directory> searchList = new LinkedList<>();
        searchList.add(root);

        while (searchList.size() != 0) {
            Directory nod = searchList.remove();
            for (Object obj : nod.folder) {
                if (obj instanceof Directory) {
                    searchList.add((Directory) obj);
                }
            }

            int dirSize = nod.sizeCount();

            if (dirSize <= 100000) {
                sum += dirSize;
            }

            if (dirSize > spaceNeeded && dirSize < minDirectory) {
                minDirectory = dirSize;
            }
        }
        
        System.out.println("Part 1 Answer: " + sum);
        System.out.println("Part 2 Answer: " + minDirectory);
    }
}