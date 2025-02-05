import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static final int MOD = 1_000_000_000;
    static int[][] dp = new int[101][10];

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());

        // 초기값 설정
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // DP 계산
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD; // j-1에서 오는 경우
                if (j < 9) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD; // j+1에서 오는 경우
            }
        }

        // 결과 계산
        int ans = 0;
        for (int i = 1; i < 10; i++) { // 0으로 시작하는 숫자는 없으므로 i=1부터 시작
            ans = (ans + dp[n][i]) % MOD;
        }

        // 출력
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
