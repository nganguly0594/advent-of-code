package day12;

/**
 * day12
 */

import java.io.*;
import java.util.*;

public class day12 {
    public static void main(String[] args) throws IOException {
        Scanner scanfile = new Scanner(new File("day12/input.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while (scanfile.hasNext()) {
            inputs.add(scanfile.next());
        }

        //---------part 1 and part 2----------
        HashMap<String, ArrayList<String>> adjacencyList = new HashMap<>();
        HashMap<String, Integer> nodeVisits = new HashMap<>();
        ArrayList<String> allPaths = new ArrayList<>();
        
        for (String line : inputs) {
            String[] parts = line.split("-");
            String firstNode = parts[0];
            String secondNode = parts[1];

            if (adjacencyList.get(firstNode) == null) {
                ArrayList<String> firstNeighbor = new ArrayList<>();
                firstNeighbor.add(secondNode);
                adjacencyList.put(firstNode, firstNeighbor);
            }
            else {
                adjacencyList.get(firstNode).add(secondNode);
            }
            if (adjacencyList.get(secondNode) == null) {
                ArrayList<String> firstNeighbor = new ArrayList<>();
                firstNeighbor.add(firstNode);
                adjacencyList.put(secondNode, firstNeighbor);
            }
            else {
                adjacencyList.get(secondNode).add(firstNode);
            }
        }

        for (String key : adjacencyList.keySet()) {
            if (key.toLowerCase().equals(key)) {
                nodeVisits.put(key, 9);
            }
            else {
                nodeVisits.put(key, 0);
            }
        }

        for (String neighbor : adjacencyList.get("start")) {
            pathsearchone(neighbor, adjacencyList, new HashMap<>(nodeVisits), allPaths, "start");
        }
        
        System.out.println("Part 1 Answer: " + allPaths.size());

        allPaths.clear();

        for (String neighbor : adjacencyList.get("start")) {
            pathsearchtwo(neighbor, adjacencyList, new HashMap<>(nodeVisits), allPaths, "start", false);
        }
        
        System.out.println("Part 2 Answer: " + allPaths.size());
    }

    public boolean contains(String node, ArrayList<String> neighbors) {
        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).equals(node)) {
                return true;
            }
        }

        return false;
    }

    public static void pathsearchone(String node, HashMap<String, ArrayList<String>> adjacents, HashMap<String, Integer> visitNum, ArrayList<String> paths, String currentPath) {
        currentPath += "," + node;
        if (node.equals("end")) {
            paths.add(currentPath);
            return;
        }

        if(node.equals(node.toLowerCase())) {
            visitNum.put(node, visitNum.get(node) + 1);
        }

        for (String neighbor : adjacents.get(node)) {
            if (!neighbor.equals("start") && visitNum.get(neighbor) < 10)
            pathsearchone(neighbor, adjacents, new HashMap<>(visitNum), paths, currentPath);
        }
    }

    public static void pathsearchtwo(String node, HashMap<String, ArrayList<String>> adjacents, HashMap<String, Integer> visitNum, ArrayList<String> paths, String currentPath, boolean twice) {
        currentPath += "," + node;
        if (node.equals("end")) {
            paths.add(currentPath);
            return;
        }

        if(node.equals(node.toLowerCase())) {
            visitNum.put(node, visitNum.get(node) + 1);
        }

        if (visitNum.get(node) > 10) {
            twice = true;
        }

        for (String neighbor : adjacents.get(node)) {
            if (twice) {
                if (!neighbor.equals("start") && visitNum.get(neighbor) < 10)
                pathsearchtwo(neighbor, adjacents, new HashMap<>(visitNum), paths, currentPath, twice);
            }
            else {
                if (!neighbor.equals("start") && visitNum.get(neighbor) < 11)
                pathsearchtwo(neighbor, adjacents, new HashMap<>(visitNum), paths, currentPath, twice);
            }
        }
    }
}