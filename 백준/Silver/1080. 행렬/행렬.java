import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] baseArr;
    static int[][] targetArr;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        baseArr = new int[N][M];
        targetArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                baseArr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                targetArr[i][j] = s.charAt(j) - '0';
            }
        }

        if (N < 3 || M < 3) {
            if (isSame()) {
                bw.write("0");
            } else {
                bw.write("-1");
            }
            bw.flush();
            bw.close();
            return;
        }

        int answer = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (baseArr[i][j] != targetArr[i][j]) {
                    changeBoard(i, j);
                    answer++;
                }
            }
        }

        if(isSame()) {
            bw.write(answer + "");
        } else {
            bw.write("-1");
        }


        bw.flush();
        bw.close();
    }

    public static void changeBoard(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (baseArr[i][j] == 0) {
                    baseArr[i][j] = 1;
                } else {
                    baseArr[i][j] = 0;
                }
            }
        }
    }

    public static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (baseArr[i][j] != targetArr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }




    public static void main(String[] args) throws IOException {
        solution();
    }
}