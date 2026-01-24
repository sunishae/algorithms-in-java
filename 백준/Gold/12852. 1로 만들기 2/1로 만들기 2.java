import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[2][1000001];

        dp[0][2] = 1;
        dp[1][2] = 1;
        dp[0][3] = 1;
        dp[1][3] = 1;

        for(int i = 4; i <= N; i++){
            dp[0][i] = dp[0][i-1] + 1;
            dp[1][i] = i -1;
            if (i % 2 == 0) {
                if (dp[0][i] > dp[0][i / 2] + 1) {
                    dp[0][i] = dp[0][i / 2] + 1;
                    dp[1][i] = i / 2;
                }
            }
            if (i % 3 == 0) {
                if (dp[0][i] > dp[0][i / 3] + 1) {
                    dp[0][i] = dp[0][i / 3] + 1;
                    dp[1][i] = i / 3;
                }
            }
        }

        bw.write(dp[0][N] + "\n");
        int cur = N;
        bw.write(N + " ");
        while (dp[1][cur] != 0) {
            bw.write(dp[1][cur] + " ");
            cur = dp[1][cur];
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
