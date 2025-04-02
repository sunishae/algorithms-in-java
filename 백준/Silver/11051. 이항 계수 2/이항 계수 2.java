import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp;
    static int cnt = 0;
    static final int MOD = 10007;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new long[n + 1][k + 1];


        bw.write(bin(n,k) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static long bin(int n, int k) {
        cnt++;
        if (k == 0 || k == n)
            return 1;

        if (dp[n][k] != 0)
            return dp[n][k];

        dp[n][k] = (bin(n - 1, k - 1) + bin(n - 1, k)) % MOD;

        return dp[n][k];
    }



    public static void main(String[] args) throws Exception {
        solution();
    }
}
