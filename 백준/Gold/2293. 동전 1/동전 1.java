import java.io.*;
import java.util.*;

public class Main {
    static int n; // 동전 종류
    static int k; // 가치의 합
    static int[] coin;
    static int[] dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n];
        dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            int currentCoin = coin[i];
            for (int j = currentCoin; j <= k; j++) {
                dp[j] += dp[j - currentCoin];
            }
        }

        bw.write(dp[k] + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
