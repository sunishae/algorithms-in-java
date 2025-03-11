import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] sizes, values, dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sizes = new int[n];
        values = new int[n];
        dp = new int[k + 1];  // ⚠️ dp[k]까지 접근하려면 크기를 k+1로 설정

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sizes[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        br.close(); // 입력 스트림 닫기

        // 0-1 Knapsack DP (뒤에서부터 업데이트)
        for (int j = 0; j < n; j++) {
            for (int i = k; i >= sizes[j]; i--) {  // **뒤에서부터 갱신**
                dp[i] = Math.max(dp[i], dp[i - sizes[j]] + values[j]);
            }
        }

        // 결과 출력 (BufferedWriter 대신 System.out.println() 사용 가능)
        System.out.println(dp[k]);  
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
