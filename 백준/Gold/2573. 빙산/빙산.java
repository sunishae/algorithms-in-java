import java.io.*;
import java.util.*;

public class Main {
    static int row; // 행
    static int col; // 열
    static int[][] map; // 맵
    static int[][] nextMap; // 다음 년도 맵
    static boolean[][] visited; // 두동강 확인
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        nextMap = new int[row][col];

        // 빙하 정보 입력
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while(true) {
            // 1. 빙산 그룹 개수 세기
            int count = 0;
            visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            // 2. 종료 조건 체크
            if (count >= 2) { // 두 덩어리 이상 분리됨
                bw.write(ans + "");
                break;
            }
            if (count == 0) { // 다 녹을 때까지 분리 안 됨
                bw.write("0");
                break;
            }

            // 3. 빙산 녹이기
            nextMap = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] > 0) {
                        fuze(i, j);
                    }
                }
            }

            // 4. map 업데이트 및 년수 증가
            for (int i = 0; i < row; i++) {
                map[i] = nextMap[i].clone(); // 차기 정보를 현재 맵으로 복사
            }
            ans++;
        }

        bw.flush();
        bw.close();
    }

    public static void fuze(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (map[nextX][nextY] == 0) {
                cnt++;
            }
        }

        int result = map[x][y] - cnt;
        if (result < 0) {
            result = 0;
        }
        nextMap[x][y] = result;
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if (map[nextX][nextY] > 0 && !visited[nextX][nextY]) {
                    q.offer(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}
