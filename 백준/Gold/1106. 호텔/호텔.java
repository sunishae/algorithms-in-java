import java.io.*;
import java.util.*;

public class Main {
    static int N;   // 도시 수
    static int C;   // 늘려야할 고객 목표
    static int[] dp;
    static final int MAX = 987654321;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[C + 101];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());

            for (int j = person; j < C + 100; j++) {
                if (dp[j - person] != MAX) {
                    dp[j] = Math.min(dp[j], dp[j - person] + cost);
                }
            }
        }

        int result = MAX;
        for (int i = C; i <= C + 100; i++) {
            result = Math.min(result, dp[i]);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
