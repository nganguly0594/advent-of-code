package day7;

import java.util.*; 

public class Directory {
    public String name;
    public Directory parentdir;
    public ArrayList<Object> folder;

    public Directory(String nam) {
        name = nam;
        folder = new ArrayList<>();
        parentdir = null;
    }

    public void setParent(Directory par) {
        parentdir = par;
    }

    public void add(Object obj) {
        folder.add(obj);
    }

    public Directory get(String nam) {
        for (Object child : folder) {
            if (child instanceof Directory) {
                Directory childDirectory = (Directory) child;
                if (childDirectory.name.equals(nam)) {
                    return childDirectory;
                }
            }
        }
        return null;
    }

    public int sizeCount() {
        int count = 0;
        for (Object obj : folder) {
            if (obj instanceof Files) {
                Files file = (Files) obj;
                count += file.size;
            }
            else {
                Directory nod = (Directory) obj;
                count += nod.sizeCount();
            }
        }

        return count;
    }

    public String toString() {
        return "Directory: " + name + " Things Inside: " + folder.size();
    }
}
