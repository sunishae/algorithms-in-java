import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max;
    static int[][] schedule;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 기간 (T)
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 이익 (P)
        }

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int index, int sum) {
        max = Math.max(max, sum); // 매 호출에서 최대값 갱신

        for (int i = index; i < N; i++) {
            // 작업이 N일을 초과하면 건너뜀
            if (i + schedule[i][0] > N) continue;
            // 다음 작업은 현재 작업 종료 후부터 선택
            dfs(i + schedule[i][0], sum + schedule[i][1]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}