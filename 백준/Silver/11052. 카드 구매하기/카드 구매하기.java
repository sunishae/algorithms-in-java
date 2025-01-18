import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 1 <= N 1,000
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
