import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int r, c;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int cnt;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 북 0, 동 1, 남 2, 서 3

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startClean(d);
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    public static void startClean(int d) {
        cnt = 0;
        while (true) {
            if (room[r][c] == 0) { // 현재 위치 청소
                room[r][c] = 2;
                cnt++;
            }

            boolean dirty = false;
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                if (room[nx][ny] == 0) { // 청소되지 않은 공간이 있으면
                    dirty = true;
                    break;
                }
            }

            if (!dirty) { // 4방향 모두 청소됨
                if (!goBack(d)) break; // 후진 불가능하면 종료
                continue;
            }

            // 반시계 방향 회전
            d = (d + 3) % 4;
            int nx = r + dx[d];
            int ny = c + dy[d];

            if (room[nx][ny] == 0) { // 청소되지 않은 칸이면 전진
                r = nx;
                c = ny;
            }
        }
    }

    public static boolean goBack(int d) {
        int back = (d + 2) % 4;
        int nx = r + dx[back];
        int ny = c + dy[back];

        if (room[nx][ny] != 1) { // 벽이 아니면 후진
            r = nx;
            c = ny;
            return true;
        }
        return false; // 벽이면 후진 불가능
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
