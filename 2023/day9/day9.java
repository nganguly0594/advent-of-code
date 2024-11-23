package day9;
/**
 * day9
 */

import java.io.*;
import java.util.*;

public class day9 {

    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day9/input.txt"));
        ArrayList<ArrayList<Long>> patterns = new ArrayList<>();

        while (scanfile.hasNext()) {
            Scanner ss = new Scanner(scanfile.nextLine());

            ArrayList<Long> pattern = new ArrayList<>();

            while (ss.hasNextLong()) {
                pattern.add(ss.nextLong());
            }

            patterns.add(pattern);
        }

        //----------part 1----------
        long rightSum = 0;
        long leftSum = 0;

        for (ArrayList<Long> pattern : patterns) {
            rightSum += extrapolate(pattern, true);
            leftSum += extrapolate(pattern, false);
        }

        System.out.println("Part 1 Answer: " + rightSum);
        System.out.println("Part 2 Answer: " + leftSum);
    }

    public static long extrapolate(ArrayList<Long> pattern, boolean partOne) {
        ArrayList<ArrayList<Long>> lists = new ArrayList<>();
        lists.add(pattern);

        ArrayList<Long> last = lists.get(0);
        
        while (!allZeros(last)) {
            ArrayList<Long> list = new ArrayList<>();

            for (int i = 0; i < last.size() - 1; i++) {
                list.add(last.get(i + 1) - last.get(i));
            }

            lists.add(list);
            last = lists.get(lists.size() - 1);;
        }

        last.add((long) 0);

        while (lists.size() > 1) {
            last = lists.get(lists.size() - 1);
            long diff = (partOne) ? last.get(last.size() - 1) : last.get(0);
            ArrayList<Long> pen = lists.get(lists.size() - 2);
            if (partOne) {
                pen.add(pen.get(pen.size() - 1) + diff);
            }
            else {
                pen.add(0, pen.get(0) - diff);
            }
            lists.remove(lists.size() - 1);
        }

        last = lists.get(lists.size() - 1);

        return (partOne) ? last.get(last.size() - 1) : last.get(0);
    }

    public static boolean allZeros(ArrayList<Long> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}