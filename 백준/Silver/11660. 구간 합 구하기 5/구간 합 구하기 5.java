import java.io.*;
import java.util.*;

public class Main {
    static int n; // 표의 크기
    static int m; // 합 개수
    static int[][] arr;
    static int[][] dp;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + arr[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int result = partSum(x1, y1, x2, y2);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int partSum(int x1, int y1, int x2, int y2) {
        int sum = 0;

        for (int i = x1; i <= x2; i++) {
            if(y1 == 0){
                sum += dp[i][y2];
            }
            else
                sum += dp[i][y2] - dp[i][y1-1];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
