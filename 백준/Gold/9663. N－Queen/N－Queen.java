import java.io.*;

public class Main {
    static int n;
    static int cnt;
    static boolean[] col, diag1, diag2;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        cnt = 0;

        // 열, 대각선 사용 여부 체크 배열
        col = new boolean[n];        // 같은 열 체크
        diag1 = new boolean[2 * n];  // 우하향 대각선 체크 (r + c)
        diag2 = new boolean[2 * n];  // 좌하향 대각선 체크 (r - c + n)

        dfs(0); // 0번째 행부터 탐색

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int c = 0; c < n; c++) { // 현재 행(row)에 대해 모든 열(c) 탐색
            if (col[c] || diag1[row + c] || diag2[row - c + n]) continue;

            col[c] = diag1[row + c] = diag2[row - c + n] = true; // 퀸 배치
            dfs(row + 1); // 다음 행 탐색
            col[c] = diag1[row + c] = diag2[row - c + n] = false; // 백트래킹 (원상복구)
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
