import java.io.*;
import java.util.*;

public class Main {
    static int n, m, b;
    static int[][] ground;
    static int resultTime = Integer.MAX_VALUE;
    static int resultHeight = -1;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int min = 256;
        int max = 0;
        ground = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int t = Integer.parseInt(st.nextToken());
                ground[i][j] = t;
                min = Math.min(min, t);
                max = Math.max(max, t);
            }
        }

        for (int i = min; i <= max; i++) {
            checkGround(i);
        }

        bw.write(resultTime + " " + resultHeight + "\n");
        bw.flush();
        bw.close();
    }

    public static void checkGround(int height) {
        int time = 0;
        int block = b;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = ground[i][j] - height;
                if (diff > 0) { // 블록 제거
                    time += diff * 2;
                    block += diff;
                } else if (diff < 0) { // 블록 추가
                    time -= diff;
                    block += diff;
                }
            }
        }

        if (block < 0) return;

        if (time < resultTime || (time == resultTime && height > resultHeight)) {
            resultTime = time;
            resultHeight = height;
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
