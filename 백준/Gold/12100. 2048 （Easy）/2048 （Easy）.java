import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans = 0;
    // dx, dy를 상하좌우에 맞게 재정의 (행, 열 기준)
    static int[] dy = {-1, 1, 0, 0}; // 상, 하 (행 변화)
    static int[] dx = {0, 0, -1, 1}; // 좌, 우 (열 변화)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(ans);
    }

    public static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            ans = Math.max(ans, searchMax(board));
            return;
        }

        dfs(depth + 1, move(board, 0)); // 상
        dfs(depth + 1, move(board, 1)); // 하
        dfs(depth + 1, move(board, 2)); // 좌
        dfs(depth + 1, move(board, 3)); // 우
    }

    public static int[][] move(int[][] board, int dir) {
        int[][] nextBoard = copyBoard(board);
        boolean[][] merged = new boolean[N][N]; // 한 턴에 한 번만 합쳐지게 체크

        if (dir == 0 || dir == 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    forward(nextBoard, merged, i, j, dir);
                }
            }
        } else {
            for (int i = N - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    forward(nextBoard, merged, i, j, dir);
                }
            }
        }
        return nextBoard;
    }

    public static void forward(int[][] board, boolean[][] merged, int r, int c, int dir) {
        if (board[r][c] == 0) return;

        int curR = r;
        int curC = c;
        while (true) {
            int nextR = curR + dy[dir];
            int nextC = curC + dx[dir];

            // 범위를 벗어나면 정지
            if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) break;

            if (board[nextR][nextC] == 0) {
                // 빈 칸이면 이동
                board[nextR][nextC] = board[curR][curC];
                board[curR][curC] = 0;
                curR = nextR;
                curC = nextC;
            } else if (board[nextR][nextC] == board[curR][curC] && !merged[nextR][nextC]) {
                // 숫자가 같고, 대상 칸이 아직 합쳐진 적이 없다면 병합
                board[nextR][nextC] *= 2;
                board[curR][curC] = 0;
                merged[nextR][nextC] = true; // 합쳐짐 표시
                break; // 합쳐진 후에는 더 이상 이동 불가
            } else {
                break;
            }
        }
    }

    public static int[][] copyBoard(int[][] board) {
        int[][] next = new int[N][N];
        for (int i = 0; i < N; i++) {
            next[i] = board[i].clone();
        }
        return next;
    }

    public static int searchMax(int[][] board) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }
}