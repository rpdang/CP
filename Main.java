import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int n = r.nextInt();
        System.out.println(n);
        r.close();
    }
}