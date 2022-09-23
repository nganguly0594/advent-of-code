package test;

public class test {
    public static void main (String[] args) {
        String word = "hello";
        String[] parts = word.split("");
        int x = 1;
        for (String hi : parts) {
            System.out.println(x + hi);
            x++;
        }
    }
}
