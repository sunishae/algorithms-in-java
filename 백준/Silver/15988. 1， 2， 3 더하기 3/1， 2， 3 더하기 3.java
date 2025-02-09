import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    final static int MOD = 1000000009;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
            }
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
