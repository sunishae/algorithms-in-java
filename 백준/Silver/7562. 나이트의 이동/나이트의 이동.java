import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int size;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            size = Integer.parseInt(br.readLine());
            board = new int[size][size];
            visited = new boolean[size][size];
            queue.clear(); // 큐 초기화

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int dstX = Integer.parseInt(st.nextToken());
            int dstY = Integer.parseInt(st.nextToken());

            int result = bfs(startX, startY, dstX, dstY);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int bfs(int startX, int startY, int dstX, int dstY) {
        // 시작 위치가 도착 위치와 같다면 0 반환
        if (startX == dstX && startY == dstY) return 0;

        board[startX][startY] = 0;
        visited[startX][startY] = true;
        queue.add(new Point(startX, startY));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int k = 0; k < 8; k++) {
                int nextX = current.x + dx[k];
                int nextY = current.y + dy[k];

                // 범위 체크
                if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) continue;
                // 이미 방문한 곳은 건너뛰기
                if (visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                board[nextX][nextY] = board[current.x][current.y] + 1;
                queue.add(new Point(nextX, nextY));

                // 목표 지점에 도달하면 결과 반환
                if (nextX == dstX && nextY == dstY) {
                    return board[nextX][nextY];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
