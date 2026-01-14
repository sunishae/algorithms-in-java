import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int target = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                dp[i][j] = Integer.parseInt(st.nextToken()) + target;
            }
        }

        bw.write(dp[N][M] + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
