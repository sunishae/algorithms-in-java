import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n; // 세로 (행)
    static int m; // 가로 (열)
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        Queue<Point> queue = new LinkedList<>();

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j)); // 익은 토마토 큐에 저장
                }
            }
        }

        // BFS 탐색
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                // 범위 체크
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                // 벽(-1)이거나 이미 익은 토마토가 있는 경우
                if(map[nextX][nextY] != 0) continue;

                map[nextX][nextY] = map[current.x][current.y] + 1;
                queue.offer(new Point(nextX, nextY));
            }
        }

        // 결과 확인
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 익지 않은 토마토가 남아 있는 경우
                if(map[i][j] == 0) {
                    bw.write("-1\n");
                    bw.flush();
                    bw.close();
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }

        // 모든 토마토가 익은 경우 (최초 시작이 1이었으므로 -1)
        bw.write((max - 1) + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
