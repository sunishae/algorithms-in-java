import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] weight;
    static boolean[] visit;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        weight = new int[n][n];
        visit = new boolean[n];
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0번 도시에서 시작
        visit[0] = true;
        arr[0] = 0;
        dfs(1);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) {
        if (depth == n) {
            // 마지막 도시에서 시작 도시로 돌아가는 비용 추가
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (weight[arr[i]][arr[i + 1]] == 0) return; // 경로가 없는 경우
                sum += weight[arr[i]][arr[i + 1]];
            }

            // 마지막 도시에서 시작 도시로 돌아오는 비용 체크
            if (weight[arr[n - 1]][arr[0]] == 0) return;
            sum += weight[arr[n - 1]][arr[0]];

            // 최소 비용 갱신
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < n; i++) { // 0번 도시는 이미 방문한 상태
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
