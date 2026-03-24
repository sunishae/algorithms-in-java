import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int cnt;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == '.') {
                    map[i][j] = 0;
                } else{
                    map[i][j] = 1;
                }
            }
        }

        map[R - 1][0] = 1;
        cnt = 0;
        dfs(R - 1, 0, 1);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, int depth) {
        // 도착점에 도달했을 때
        if (x == 0 && y == C - 1) { // 목적지가 오른쪽 위(0, C-1)라면
            if (depth == K) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < R && nx >= 0 && ny < C && ny >= 0) {
                if(map[nx][ny] == 0){
                    map[nx][ny] = 1;
                    dfs(nx, ny, depth + 1);
                    map[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}