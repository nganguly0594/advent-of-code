import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day8/input.txt"));

        char[] directions = scanfile.nextLine().toCharArray();
        scanfile.nextLine();

        Map<String, ArrayList<String>> nodes = new HashMap<>();

        while (scanfile.hasNext()) {
            String[] line = scanfile.nextLine().replace(" = (", ", ").replace(")", "").split(", ");
            nodes.put(line[0], new ArrayList<>());
            nodes.get(line[0]).add(line[1]);
            nodes.get(line[0]).add(line[2]);
        }

        System.out.println("instruct length: " + directions.length);

        String curr = "GGA";

        int count = 0;

        while (count < 100000) {
            curr = (directions[count % directions.length] == 'L') ? nodes.get(curr).get(0) : nodes.get(curr).get(1);
            count++;
            if (curr.charAt(2) == 'Z') {
                System.out.println(curr + " " + count);
            }
        }
    }
}