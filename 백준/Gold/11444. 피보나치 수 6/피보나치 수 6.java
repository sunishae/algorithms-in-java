import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long[][] base = {{1, 1}, {1, 0}};
        long[][] result = matrixPow(base, n - 1);

        bw.write(result[0][0] + "");
        br.close();
        bw.close();
    }

    // 행렬 제곱 (분할 정복)
    public static long[][] matrixPow(long[][] a, long n) {
        if(n == 1 || n == 0) return a;

        long[][] half = matrixPow(a, n / 2);
        long[][] result = matrixMul(half, half);

        if(n % 2 == 1){
            result = matrixMul(result, a);
        }

        return result;
    }

    // 행렬 곱
    public static long[][] matrixMul(long[][] a, long[][] b) {
        long[][] result = new long[2][2];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}