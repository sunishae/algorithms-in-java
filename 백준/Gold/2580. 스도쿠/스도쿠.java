import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static boolean flag = false;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    public static void dfs(int r, int c) {
        if (c == 9) {
            dfs(r + 1, 0);
            return;
        }

        if(r == 9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        if (board[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                // i 값이 중복되지 않는지 검사
                if (possibility(r, c, i)) {
                    board[r][c] = i;
                    dfs(r, c + 1);
                }
            }
            board[r][c] = 0;
            return;
        }

        dfs(r, c + 1);
    }

    public static boolean possibility(int row, int col, int value) {

        // 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사.
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // 3*3 칸에 중복되는 원소가 있는지 검사
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;	// 중복되는 것이 없을 경우 true 반환
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}