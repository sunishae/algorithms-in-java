import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int safeArea = 0; // 최소값이 아니라 최대값을 찾아야 하므로 초기값 변경

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(i, j, 1);
                    map[i][j] = 0;
                }
            }
        }

        bw.write(safeArea + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int startX, int startY, int depth) {
        if (depth == 3) {
            int[][] tempMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                tempMap[i] = map[i].clone();
            }

            spreadVirus(tempMap);
            safeArea = Math.max(safeArea, countArea(tempMap));
            return;
        }

        for (int i = startX; i < n; i++) {
            for (int j = (i == startX ? startY : 0); j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(i, j, depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void spreadVirus(int[][] tempMap) {
        Queue<Point> virusQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    virusQueue.add(new Point(i, j));
                }
            }
        }

        while (!virusQueue.isEmpty()) {
            Point current = virusQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    virusQueue.add(new Point(nx, ny));
                }
            }
        }
    }

    public static int countArea(int[][] tempMap) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
