import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] sensor;
    static Integer[] interval;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sensor = new int[N];
        interval = new Integer[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        for (int i = 0; i < N - 1; i++) {
            interval[i] = sensor[i + 1] - sensor[i];
        }

        Arrays.sort(interval, Collections.reverseOrder());

        int ans = 0;
        for (int i = K - 1; i < N - 1; i++) {
            ans += interval[i];
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}