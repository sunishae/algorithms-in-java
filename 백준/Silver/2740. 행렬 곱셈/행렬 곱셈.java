import java.io.*;
import java.util.*;

public class Main {
    static int[][] A;
    static int A_r;
    static int A_c;
    static int[][] B;
    static int B_r;
    static int B_c;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A_r = Integer.parseInt(st.nextToken());
        A_c = Integer.parseInt(st.nextToken());
        A = new int[A_r][A_c];
        for (int i = 0; i < A_r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A_c; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        B_r = Integer.parseInt(st.nextToken());
        B_c = Integer.parseInt(st.nextToken());
        B = new int[B_r][B_c];
        for (int i = 0; i < B_r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B_c; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] C = new int[A_r][B_c];
        for (int i = 0; i < A_r; i++) {
            for (int j = 0; j < B_c; j++) {
                for (int k = 0; k < A_c; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for (int i = 0; i < A_r; i++) {
            for (int j = 0; j < B_c; j++) {
                bw.write(C[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
