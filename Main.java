import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Main {

    void solve() throws Exception {
        int a = nextInt(), b = nextInt();
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += i == 6 ? b : a;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        System.err.println(System.currentTimeMillis() - s + "ms");
    }

    byte[] inbuf = new byte[1024];
    int lenbuf = 0, ptrbuf = 0;
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    final int inf = (int) 1e9 + 9;
    // int[] dx = {0,0,1,-1};
    // int[] dy = {1,-1,0,0};
    // int[] ddx = {0,0,1,-1,1,-1,1,-1};
    // int[] ddy = {1,-1,0,0,1,-1,-1,1};

    long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private double nextDouble() {
        return Double.parseDouble(nextString());
    }

    private int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    private int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            if (b == '-') {
                minus = true;
                b = readByte();
            }
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nextLong() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private int[][] nextGrid() {
        // Read the number of rows and columns
        int rows = nextInt();
        int cols = nextInt();

        // Initialize the grid
        int[][] grid = new int[rows][cols];

        // Read each cell of the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = nextInt();
            }
        }

        return grid;
    }

    private int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }
}
