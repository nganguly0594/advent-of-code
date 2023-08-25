package day7; 

public class Files {
    public String name;
    public int size;
    
    public Files(String nam, int siz) {
        name = nam;
        size = siz;
    }

    public String toString() {
        return "File: " + name + " Size: " + size;
    }
}