import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] house;
    static int ans;

    public static void solution() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1-based
        N = Integer.parseInt(br.readLine());
        house = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                house[i][j] = n;
            }
        }

        ans = 0;

        dp(1,1,1,2);

        bw.write(ans + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dp(int r1, int c1, int r2, int c2) {
        if(r2 == N && c2 == N) {
            ans++;
            return;
        }

        if(r1 == r2) { // 가로
            if(c2 + 1 <= N && house[r2][c2 + 1] == 0) // 수평 이동
                dp(r2, c2, r2, c2 + 1);

            if (r2 + 1 <= N && c2 + 1 <= N) { // 대각 이동
                if (house[r2][c2 + 1] == 0 && house[r2 + 1][c2] == 0 && house[r2 + 1][c2 + 1] == 0) {
                    dp(r2, c2, r2 + 1, c2 + 1);
                }
            }

        } else if (c1 == c2) { // 세로
            if (r2 + 1 <= N && house[r2 + 1][c2] == 0) { // 수직 이동
                dp(r2, c2, r2 + 1, c2);
            }

            if (r2 + 1 <= N && c2 + 1 <= N) { // 대각 이동
                if (house[r2][c2 + 1] == 0 && house[r2 + 1][c2] == 0 && house[r2 + 1][c2 + 1] == 0) {
                    dp(r2, c2, r2 + 1, c2 + 1);
                }
            }

        } else { // 대각선
            if(c2 + 1 <= N && house[r2][c2 + 1] == 0) // 수평 이동
                dp(r2, c2, r2, c2 + 1);

            if (r2 + 1 <= N && house[r2 + 1][c2] == 0) { // 수직 이동
                dp(r2, c2, r2 + 1, c2);
            }

            if (r2 + 1 <= N && c2 + 1 <= N) { // 대각 이동
                if (house[r2][c2 + 1] == 0 && house[r2 + 1][c2] == 0 && house[r2 + 1][c2 + 1] == 0) {
                    dp(r2, c2, r2 + 1, c2 + 1);
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}
