import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0 ,1 ,0};
    static int[] dy = {0, -1, 0, 1};

    public static class Point{
        int x;
        int y;
        int cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                } else if(map[i][j] == 1) map[i][j] = -1;
            }
        }

        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c, 0));
        visited[r][c] = true;
        map[r][c] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nCnt = p.cnt + 1;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && map[nx][ny] == -1){
                        q.add(new Point(nx, ny, nCnt));
                        visited[nx][ny] = true;
                        map[nx][ny] = nCnt;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
