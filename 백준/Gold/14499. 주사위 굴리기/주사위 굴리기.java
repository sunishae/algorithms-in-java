import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] dice = new int[6];  // 주사위를 1차원 배열로 표현
    static int[] dx = {0, 0, -1, 1}; // 동, 서, 북, 남
    static int[] dy = {1, -1, 0, 0}; // 동, 서, 북, 남

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            if (move(dir)) {
                bw.write(dice[0] + "\n"); // 윗면 출력
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean move(int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) return false; // 범위 초과 시 무시
        x = nx;
        y = ny;

        rollDice(dir); // 주사위 회전

        // 주사위 바닥면과 지도의 값 교환
        if (map[x][y] == 0) {
            map[x][y] = dice[5]; // 주사위 바닥면이 지도에 복사됨
        } else {
            dice[5] = map[x][y]; // 지도의 값이 주사위 바닥으로 복사됨
            map[x][y] = 0;
        }

        return true;
    }

    public static void rollDice(int dir) {
        int[] temp = dice.clone();

        if (dir == 0) { // 동쪽
            dice[0] = temp[3];
            dice[2] = temp[0];
            dice[5] = temp[2];
            dice[3] = temp[5];
        } else if (dir == 1) { // 서쪽
            dice[0] = temp[2];
            dice[2] = temp[5];
            dice[5] = temp[3];
            dice[3] = temp[0];
        } else if (dir == 2) { // 북쪽
            dice[0] = temp[4];
            dice[1] = temp[0];
            dice[5] = temp[1];
            dice[4] = temp[5];
        } else { // 남쪽
            dice[0] = temp[1];
            dice[1] = temp[5];
            dice[5] = temp[4];
            dice[4] = temp[0];
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
