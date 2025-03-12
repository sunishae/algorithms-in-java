import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static long[] dp = new long[1000001];
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        bw.write(dp[n] + "");
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
