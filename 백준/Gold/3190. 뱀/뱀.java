import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int dir;
    static Queue<Point> snake = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};
    static Map<Integer, Character> turnInfo = new HashMap<>();

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
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            board[s][e] = 1; // 사과 위치는 1로 표시
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char turn = st.nextToken().charAt(0);
            turnInfo.put(sec, turn);
        }

        int time = 0;
        int headX = 1;
        int headY = 1;
        board[headX][headY] = 2; // 뱀의 몸통은 2로 표시
        snake.add(new Point(headX, headY));
        dir = 0; // 초기 방향은 오른쪽

        while (true) {
            time++;

            // 1. 머리를 다음 칸으로 이동
            int nextX = headX + dx[dir];
            int nextY = headY + dy[dir];

            // 2. 게임 종료 조건 확인 (벽 또는 몸통 충돌)
            if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || board[nextX][nextY] == 2) {
                break;
            }

            // 3. 사과 유무에 따른 로직 처리
            if (board[nextX][nextY] == 1) { // 사과가 있으면
                board[nextX][nextY] = 2;
                snake.add(new Point(nextX, nextY));
            } else { // 사과가 없으면
                board[nextX][nextY] = 2;
                snake.add(new Point(nextX, nextY));
                Point tail = snake.poll();
                board[tail.x][tail.y] = 0;
            }
            headX = nextX;
            headY = nextY;

            // 4. 방향 전환 정보 확인
            if (turnInfo.containsKey(time)) {
                if (turnInfo.get(time) == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽으로 회전
                } else {
                    dir = (dir + 1) % 4; // 오른쪽으로 회전
                }
            }
        }

        bw.write(time + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
