import java.io.*;
import java.util.*;

public class Main {
    static int H;
    static int W;
    static int X;
    static int Y;
    static int[][] A;
    static int[][] B;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        A = new int[H][W];
        B = new int[H + X][W + Y];

        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i >= X && j >= Y) {
                    A[i][j] = B[i][j] - A[i - X][j - Y];
                } else {
                    A[i][j] = B[i][j];
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                bw.write(A[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
