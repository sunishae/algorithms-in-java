import java.io.*;
import java.util.*;

public class Main {
    static int n; // 동전 종류
    static int k; // 가치의 합
    static int[] coin;
    static int[] dp;
    static final int INF = 987654321;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 동전의 개수가 최소
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n];
        dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            int currentCoin = coin[i];
            for (int j = currentCoin; j <= k; j++) {
                if (dp[j - currentCoin] != INF) {
                    dp[j] = Math.min(dp[j], dp[j - currentCoin] + 1);
                }
            }

        }

        if (dp[k] == INF) {
            bw.write("-1");
        } else {
            bw.write(dp[k] + "");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
