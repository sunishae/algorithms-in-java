import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] dp;
    static int[] arr;
    static final int MAX = 987654321;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new long[1101];
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = MAX;
        }

        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] >= MAX) continue;
            for (int j = 1; j <= arr[i]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if (dp[n] >= MAX) {
            bw.write("-1");
        } else {
            bw.write(dp[n] + "");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
