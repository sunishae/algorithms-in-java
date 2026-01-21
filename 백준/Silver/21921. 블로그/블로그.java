import java.io.*;
import java.util.*;

public class Main {
    static int N; // 총 일
    static int X; // 구간
    static int[] arr;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int max = 0;

        int i = 0;
        int j = 0;

        for (; j < X; j++) {
            max += arr[j];
        }

        int cur = max;
        while (j < N) {
            cur += arr[j++];
            cur -= arr[i++];
            if (cur > max) {
                cnt = 1;
                max = cur;
            } else if (cur == max) {
                cnt++;
//                bw.write("i : " + i + " j : " + j + " cur : " + cur + " cnt : " + cnt + "\n");
            }
        }

        if (max == 0) {
            bw.write("SAD");
        } else {
            bw.write(max + "\n" + cnt);
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
