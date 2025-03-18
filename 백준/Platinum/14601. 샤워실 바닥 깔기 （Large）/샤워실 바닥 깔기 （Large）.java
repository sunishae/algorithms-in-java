import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int cnt;

    static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        n = (int)Math.pow(2, n);
        map = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = n - (Integer.parseInt(st.nextToken()));
        map[x][y] = -1; // 장애물 위치

        cnt = 1;
        tromino(0, 0, x, y, n);

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void tromino(int r, int c, int hr, int hc, int size) {
        if (size == 2) { // 2x2 블록
            for (int i = r; i < r + 2; i++) {
                for (int j = c; j < c + 2; j++) {
                    if (map[i][j] == 0) { // 빈칸 채우긴
                        map[i][j] = cnt;
                    }
                }
            }
            cnt++;
            return;
        }

        int mid = size / 2;
        int tr = r + mid;
        int tc = c + mid;

        // 장애물이 어느 사분면에 있는지 확인
        int quad = (hr < tr ? 0 : 2) + (hc < tc ? 0 : 1);

        // 중심에 새로운 장애물 배치
        if (quad != 0) map[tr - 1][tc - 1] = cnt;
        if (quad != 1) map[tr - 1][tc] = cnt;
        if (quad != 2) map[tr][tc - 1] = cnt;
        if (quad != 3) map[tr][tc] = cnt;
        cnt++;

        // 각 사분면에 대해 재귀 호출
        tromino(r, c, quad == 0 ? hr : tr - 1, quad == 0 ? hc : tc - 1, mid); // 1사분면
        tromino(r, tc, quad == 1 ? hr : tr - 1, quad == 1 ? hc : tc, mid); // 2사분면
        tromino(tr, c, quad == 2 ? hr : tr, quad == 2 ? hc : tc - 1, mid); // 3사분면
        tromino(tr, tc, quad == 3 ? hr : tr, quad == 3 ? hc : tc, mid); // 4사분면
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
