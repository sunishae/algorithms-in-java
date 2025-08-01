import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] tomato;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Point {
        int x, y, z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][M][N];
        Queue<Point> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                for (int n = 0; n < N; n++) {
                    tomato[h][m][n] = Integer.parseInt(st.nextToken());
                    if (tomato[h][m][n] == 1) {
                        q.offer(new Point(m, n, h)); // 익은 토마토는 시작점
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int d = 0; d < 6; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];

                if (check(nx, ny, nz) && tomato[nz][nx][ny] == 0) {
                    tomato[nz][nx][ny] = tomato[cur.z][cur.x][cur.y] + 1;
                    q.offer(new Point(nx, ny, nz));
                }
            }
        }

        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (tomato[h][m][n] == 0) {
                        bw.write("-1\n");
                        bw.flush();
                        return;
                    }
                    max = Math.max(max, tomato[h][m][n]);
                }
            }
        }

        bw.write((max - 1) + "\n"); // 1부터 시작했으므로 -1
        bw.flush();
        bw.close();
    }

    public static boolean check(int x, int y, int z) {
        return x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
