import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 10][N + 10];

        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int current = Integer.parseInt(st.nextToken());

                if (dp[i][j] == 0 || (i == N && j == N)) continue;

                dp[i + current][j] += dp[i][j];
                dp[i][j + current] += dp[i][j];
            }
        }

        bw.write(dp[N][N] + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
