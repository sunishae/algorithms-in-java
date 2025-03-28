import java.io.*;
import java.util.*;

public class Main {
    static int r,c;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static class Point{
        int x;
        int y;
        int cnt;
        boolean flag;

        public Point(int x, int y, int cnt, boolean flag) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.flag = flag;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c][2];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        if(r == 1 && c == 1) min = 1;
        else findShortcut();


        if (min == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(min + "");
        }

        br.close();
        bw.close();
    }

    public static void findShortcut() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1,false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx == r - 1 && ny == c - 1) { // 다음 위치가 목적지
                    min = Math.min(min, current.cnt + 1);
                }
                else if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if(map[nx][ny] == 1 && !current.flag && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.add(new Point(nx, ny, current.cnt + 1, true));
                    }
                    else if(map[nx][ny] == 0 && !visited[nx][ny][current.flag ? 1 : 0]){
                        visited[nx][ny][current.flag ? 1 : 0] = true;
                        q.add(new Point(nx, ny, current.cnt + 1, current.flag));
                    }

                }

            }
        }
    }



    public static void main(String[] args) throws Exception {
        solution();
    }
}