import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Main {

    void solve() throws Exception {
        int a = nextInt(), b = nextInt();
        System.out.println(a);
        System.out.println(b);
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        System.err.println(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
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
}

/*
 * class Reader {
 * final private int BUFFER_SIZE = 1 << 16;
 * private DataInputStream din;
 * private byte[] buffer;
 * private int bufferPointer, bytesRead;
 * 
 * public Reader() {
 * din = new DataInputStream(System.in);
 * buffer = new byte[BUFFER_SIZE];
 * bufferPointer = bytesRead = 0;
 * }
 * 
 * public Reader(String file_name) throws IOException {
 * din = new DataInputStream(
 * new FileInputStream(file_name));
 * buffer = new byte[BUFFER_SIZE];
 * bufferPointer = bytesRead = 0;
 * }
 * 
 * public String readLine() throws IOException {
 * byte[] buf = new byte[64]; // line length
 * int cnt = 0, c;
 * while ((c = read()) != -1) {
 * if (c == '\n') {
 * if (cnt != 0) {
 * break;
 * } else {
 * continue;
 * }
 * }
 * buf[cnt++] = (byte) c;
 * }
 * return new String(buf, 0, cnt);
 * }
 * 
 * public int nextInt() throws IOException {
 * int ret = 0;
 * byte c = read();
 * while (c <= ' ') {
 * c = read();
 * }
 * boolean neg = (c == '-');
 * if (neg)
 * c = read();
 * do {
 * ret = ret * 10 + c - '0';
 * } while ((c = read()) >= '0' && c <= '9');
 * 
 * if (neg)
 * return -ret;
 * return ret;
 * }
 * 
 * public long nextLong() throws IOException {
 * long ret = 0;
 * byte c = read();
 * while (c <= ' ')
 * c = read();
 * boolean neg = (c == '-');
 * if (neg)
 * c = read();
 * do {
 * ret = ret * 10 + c - '0';
 * } while ((c = read()) >= '0' && c <= '9');
 * if (neg)
 * return -ret;
 * return ret;
 * }
 * 
 * public double nextDouble() throws IOException {
 * double ret = 0, div = 1;
 * byte c = read();
 * while (c <= ' ')
 * c = read();
 * boolean neg = (c == '-');
 * if (neg)
 * c = read();
 * 
 * do {
 * ret = ret * 10 + c - '0';
 * } while ((c = read()) >= '0' && c <= '9');
 * 
 * if (c == '.') {
 * while ((c = read()) >= '0' && c <= '9') {
 * ret += (c - '0') / (div *= 10);
 * }
 * }
 * 
 * if (neg)
 * return -ret;
 * return ret;
 * }
 * 
 * private void fillBuffer() throws IOException {
 * bytesRead = din.read(buffer, bufferPointer = 0,
 * BUFFER_SIZE);
 * if (bytesRead == -1)
 * buffer[0] = -1;
 * }
 * 
 * private byte read() throws IOException {
 * if (bufferPointer == bytesRead)
 * fillBuffer();
 * return buffer[bufferPointer++];
 * }
 * 
 * public void close() throws IOException {
 * if (din == null)
 * return;
 * din.close();
 * }
 * }
 */