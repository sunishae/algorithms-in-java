import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] hot;
    static int[] dp;

    static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        hot = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hot[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 k개의 요소의 합을 구함
        for (int i = 0; i < k; i++) {
            dp[k-1] += hot[i];
        }

        // max 값을 초기화
        int max = dp[k-1];

        // 슬라이딩 윈도우를 사용하여 k개 구간합을 구함
        for (int i = k; i < n; i++) {
            dp[i] = dp[i-1] - hot[i-k] + hot[i];
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
