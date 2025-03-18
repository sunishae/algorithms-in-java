import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] mat;
    static final int MOD = 1000;

    static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = matPower(mat, k);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j == n-1)
                    bw.write(result[i][j] +"");
                else
                    bw.write(result[i][j] + " ");
            }
            if(i < n-1)
                bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    // 행렬 거듭제곱
    public static int[][] matPower(int[][] base, long exp) {
        int[][] result = identityMatrix(n); // 항등 행렬
        while (exp > 0) {
            if (exp % 2 == 1) {  // 홀수일 때 현재 행렬을 곱함
                result = matMul(result, base);
            }
            base = matMul(base, base); // 행렬 제곱
            exp /= 2;
        }
        return result;
    }

    // 행렬 곱셈
    public static int[][] matMul(int[][] a, int[][] b) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return result;
    }

    public static int[][] identityMatrix(int size) {
        int[][] I = new int[size][size];
        for (int i = 0; i < size; i++) {
            I[i][i] = 1;
        }
        return I;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
