import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    final static int MOD = 10007;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }


        for(int i = 1; i < N+1; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        bw.write(dp[N][0] % MOD + "\n");
        bw.flush();
        bw.close();
        
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
