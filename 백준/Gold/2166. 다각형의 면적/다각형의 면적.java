import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        long[][] arr = new long[2][N + 1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Long.parseLong(st.nextToken());
            arr[1][i] = Long.parseLong(st.nextToken());
        }
        arr[0][N] = arr[0][0];
        arr[1][N] = arr[1][0];

        long first = 0;
        long second = 0;
        for (int i = 1; i <= N; i++) {
            first += arr[0][i - 1] * arr[1][i];
            second += arr[1][i - 1] * arr[0][i];
        }

        double ans = Math.abs((double)(first - second) / 2.0);

        bw.write(String.format("%.1f", ans) + "\n");


        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
