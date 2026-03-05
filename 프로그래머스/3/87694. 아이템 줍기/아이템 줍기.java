import java.util.*;

class Solution {
    public static int[][] map = new int[102][102];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] r : rectangle) {
            int lx = r[0] * 2, ly = r[1] * 2, rx = r[2] * 2, ry = r[3] * 2;
            
            for (int i = lx; i <= rx; i++) {
                for (int j = ly; j <= ry; j++) {
                    if (i > lx && i < rx && j > ly && j < ry) {
                        map[i][j] = -1; // 사각형의 내부는 -1 (못 가는 곳)
                    } else if (map[i][j] != -1) {
                        map[i][j] = 1;  // 테두리는 1 (갈 수 있는 곳)
                    }
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    static int bfs(int startX, int startY, int targetX, int targetY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        boolean[][] visited = new boolean[102][102];
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == targetX && cur[1] == targetY) return cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        return 0;
    }
}