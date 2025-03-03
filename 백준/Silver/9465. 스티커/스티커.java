import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n+1];
            dp = new int[2][n+1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i <=n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            }
            int max = Math.max(dp[1][n], dp[0][n]);
            bw.write(max + "\n");
        }
        bw.flush();
        bw.close();
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
