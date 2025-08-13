import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int max = -1;
        int min = 101;
        ans = 1;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                max = Math.max(n, max);
                min = Math.min(n, min);
                map[i][j] = n;
            }
        }

        for (int i = min; i < max; i++) {
            rain(i);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void rain(int depth) {
        int cnt = 0;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] > depth) {
                    cnt++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (!visited[nx][ny] && map[nx][ny] > depth) {
                                    visited[nx][ny] = true;
                                    q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        ans = Math.max(ans, cnt);
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
