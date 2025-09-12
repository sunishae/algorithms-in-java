import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static Point red, blue, hole;
    static boolean[][][][] visited;

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class GameState {
        Point red, blue;
        int count;

        public GameState(Point red, Point blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == '#') {
                    board[i][j] = 1; // 벽
                } else if (c == '.') {
                    board[i][j] = 0; // 길
                } else if (c == 'O') {
                    board[i][j] = -1; // 출구
                    hole = new Point(i, j);
                } else if (c == 'R') {
                    board[i][j] = 0;
                    red = new Point(i, j);
                } else { // 'B'
                    board[i][j] = 0;
                    blue = new Point(i, j);
                }
            }
        }

        System.out.println(bfs());
        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        Queue<GameState> q = new LinkedList<>();
        q.add(new GameState(red, blue, 0));
        visited[red.x][red.y][blue.x][blue.y] = true;

        int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            GameState current = q.poll();
            Point curRed = current.red;
            Point curBlue = current.blue;
            int count = current.count;

            if (count >= 10) continue;

            for (int i = 0; i < 4; i++) {
                Point nextRed = move(curRed, dx[i], dy[i]);
                Point nextBlue = move(curBlue, dx[i], dy[i]);

                // 파란 공이 빠지면 실패
                if (board[nextBlue.x][nextBlue.y] == -1) continue;

                // 빨간 공만 빠지면 성공
                if (board[nextRed.x][nextRed.y] == -1) {
                    return count + 1;
                }

                // 두 공이 같은 위치에 있을 때 처리
                if (nextRed.x == nextBlue.x && nextRed.y == nextBlue.y) {
                    // 누가 먼저 이동했는지 확인하여 늦게 도착한 공을 한 칸 뒤로
                    int redDist = Math.abs(nextRed.x - curRed.x) + Math.abs(nextRed.y - curRed.y);
                    int blueDist = Math.abs(nextBlue.x - curBlue.x) + Math.abs(nextBlue.y - curBlue.y);

                    if (redDist > blueDist) {
                        nextRed.x -= dx[i];
                        nextRed.y -= dy[i];
                    } else {
                        nextBlue.x -= dx[i];
                        nextBlue.y -= dy[i];
                    }
                }

                // 방문하지 않은 상태라면 큐에 추가
                if (!visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) {
                    visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y] = true;
                    q.add(new GameState(nextRed, nextBlue, count + 1));
                }
            }
        }

        return -1;
    }
    
    public static Point move(Point start, int dx, int dy) {
        int x = start.x;
        int y = start.y;
        while (board[x + dx][y + dy] != 1 && board[x][y] != -1) {
            x += dx;
            y += dy;
        }
        return new Point(x, y);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
