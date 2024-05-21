import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer st;

    private static void solve() throws Exception {
        int a = readInt(), b = readInt();
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += i == 6 ? b : a;
        }
        out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            in = reader;
            out = writer;

            long startTime = System.currentTimeMillis();
            solve();
            out.flush();
            long endTime = System.currentTimeMillis();

            // Comment this line in actual competition for cleaner output
            System.err.println((endTime - startTime) + "ms");
        }
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return in.readLine().trim();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(in.readLine().trim());
        return st.nextToken();
    }

    // Utilities

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
