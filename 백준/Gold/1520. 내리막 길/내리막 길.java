import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        // DP 테이블을 -1로 초기화 (아직 방문하지 않았음을 의미)
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 지도 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(dfs(0, 0)));
        bw.flush();
        bw.close();
    }

    static int dfs(int x, int y) {
        // 1. 목적지에 도달한 경우 경로 1개 발견
        if (x == N - 1 && y == M - 1) {
            return 1;
        }

        // 2. 이미 계산된 적이 있는 위치라면 그 값을 즉시 반환
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        // 3. 처음 방문하는 곳이라면 일단 0으로 초기화하고 탐색 시작
        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                // 내리막길인 경우에만 이동
                if (map[x][y] > map[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}