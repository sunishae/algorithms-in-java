import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] board;
    static int[][] wboard;
    static int[][] bboard;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        wboard = new int[N + 1][M + 1];
        bboard = new int[N + 1][M + 1];

        // 입력
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = s.charAt(j - 1);
            }
        }

        // 누적합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                int wDiff = (board[i][j] == expectedW) ? 0 : 1;
                int bDiff = (board[i][j] == expectedB) ? 0 : 1;

                wboard[i][j] = wboard[i - 1][j] + wboard[i][j - 1] - wboard[i - 1][j - 1] + wDiff;
                bboard[i][j] = bboard[i - 1][j] + bboard[i][j - 1] - bboard[i - 1][j - 1] + bDiff;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i + K - 1 <= N; i++) {
            for (int j = 1; j + K - 1 <= M; j++) {
                int x2 = i + K - 1;
                int y2 = j + K - 1;

                int wCount = wboard[x2][y2] - wboard[i - 1][y2] - wboard[x2][j - 1] + wboard[i - 1][j - 1];
                int bCount = bboard[x2][y2] - bboard[i - 1][y2] - bboard[x2][j - 1] + bboard[i - 1][j - 1];

                answer = Math.min(answer, Math.min(wCount, bCount));
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
