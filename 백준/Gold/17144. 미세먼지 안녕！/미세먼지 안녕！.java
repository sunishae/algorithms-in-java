import java.io.*;
import java.util.*;

public class Main {
    static int R,C,T;
    static int vac1,vac2;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        vac2 = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) vac2 = i;
            }
        }
        vac1 = vac2 - 1;

        while (T-- > 0) {
            diffusion();
            vacuum1();
            vacuum2();
        }
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] < 0) continue;
                ans += map[i][j];
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void diffusion() {
        int[][] after = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1) {
                    after[i][j] = -1;
                    continue;
                }
                if(map[i][j] > 0){
                    int cnt = 0;
                    int n = map[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
                        if(map[nextX][nextY] == -1) continue;
                        after[nextX][nextY] += n;
                        cnt++;
                    }
                    after[i][j] += map[i][j] - n * cnt;
                }

            }
        }

        map = after;
    }

    public static void vacuum1() {
        int x = vac1;

        for (int i = x - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < x; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[x][i] = map[x][i - 1];
        map[x][1] = 0; // 바람 나오는 자리

        map[vac1][0] = -1; // 청정기 위치 복원
    }

    public static void vacuum2() {
        int x = vac2;

        for (int i = x + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > x; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[x][i] = map[x][i - 1];
        map[x][1] = 0; // 바람 나오는 자리

        map[vac2][0] = -1; // 청정기 위치 복원
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
