import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, answer;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        answer = Integer.MIN_VALUE; // integer 최소값

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);

    }

    private void dfs(int startIdx, int depth, int sum) {
        if (depth == K) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int idx = startIdx; idx < N * M; idx++) {
            int i = idx / M;
            int j = idx % M;
            if (check(i, j)) {
                visited[i][j] = true;
                dfs(idx + 1, depth + 1, sum + arr[i][j]);
                visited[i][j] = false;
            }
        }
    }

    private boolean check(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
