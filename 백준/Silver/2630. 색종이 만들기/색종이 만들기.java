import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close(); // BufferedReader 닫기

        divide(0, n - 1, 0, n - 1);

        bw.write(white + "\n" + blue);
        bw.flush();
        bw.close();
    }

    public static boolean check(int r1, int r2, int c1, int c2) {
        int test = arr[r1][c1];
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (arr[i][j] != test) return false;
            }
        }
        if (test == 0) white++;
        else blue++;

        return true;
    }

    public static void divide(int r1, int r2, int c1, int c2) {
        if (!check(r1, r2, c1, c2) && (r2 - r1 > 0) && (c2 - c1 > 0)) {
            int hr = (r1 + r2) / 2;
            int hc = (c1 + c2) / 2;

            divide(r1, hr, c1, hc);       // 좌측 상단
            divide(r1, hr, hc + 1, c2);   // 우측 상단
            divide(hr + 1, r2, c1, hc);   // 좌측 하단
            divide(hr + 1, r2, hc + 1, c2); // 우측 하단
        }
    }
}
