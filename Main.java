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
        String a = readLine(), b = readLine();
        int val = a.compareToIgnoreCase(b);
        out.println(val > 0 ? 1 : val < 0 ? -1 : 0);
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

    static int[] readArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        return arr;
    }

    static int[][] readGrid(int m, int n) throws IOException {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = readInt();
            }
        }
        return grid;
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
