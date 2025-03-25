import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        recur(n, 0, 0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void recur(int m, int x, int y) {
        int num = check(m, x, y);
        if (num == -1) {
            sb.append('(');
            recur(m / 2, x, y);                        // 2사분면
            recur(m / 2, x, y + m / 2);             // 1사분면
            recur(m / 2, x + m / 2, y);             // 3사분면
            recur(m / 2, x + m / 2, y + m / 2);  // 4사분면
            sb.append(')');
        } else {
            sb.append(num);
        }

    }

    public static int check(int m, int x, int y) {
        int sum = 0;
        for (int i = x; i < x + m; i++) {
            for (int j = y; j < y + m; j++) {
                sum += arr[i][j];
            }
        }
        if(sum == 0) return 0;
        else if(sum == m*m) return 1;
        else return -1;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}