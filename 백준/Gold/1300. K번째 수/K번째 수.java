import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int k;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        long low = 1;
        long high = k;

        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (k <= cnt) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        bw.write(String.valueOf(low));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}