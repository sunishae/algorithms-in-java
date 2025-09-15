import java.io.*;
import java.util.*;

public class Main {
    static final int SIZE = 9;
    static int[][] sudoku = new int[SIZE][SIZE];

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < SIZE; i++) {
            String s = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                sudoku[i][j] = s.charAt(j) - '0';
            }
        }

        solve_sudoku(0);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void solve_sudoku(int idx) {
        if (idx == 81) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        int x = idx / SIZE;
        int y = idx % SIZE;
        if (sudoku[x][y] == 0) {
            for (int i = 1; i <= SIZE; i++) {
                if (check(x, y, i)) {
                    sudoku[x][y] = i;
                    solve_sudoku(idx + 1);
                }
            }
            sudoku[x][y] = 0;
        } else {
            solve_sudoku(idx + 1);
        }
    }

    public static boolean check(int x, int y, int num) {

        for (int i = 0; i < SIZE; i++) {
            if(sudoku[i][y] == num) return false;
            if(sudoku[x][i] == num) return false;
        }

        int currentSquareX = x / 3;
        int currentSquareY = y / 3;

        for (int i = currentSquareX * 3; i < currentSquareX * 3 + 3; i++) {
            for (int j = currentSquareY * 3; j < currentSquareY * 3 + 3; j++) {
                if(sudoku[i][j] == num) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
