import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[0] = 1;
        for(int i = 2; i <= n; i +=2){
            dp[i] = dp[i-2] *3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j]*2;
            }
        }

        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
