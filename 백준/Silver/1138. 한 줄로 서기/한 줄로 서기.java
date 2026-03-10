import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            int cnt = -1;
            for (int j = 0; j < N; j++) {
                if(arr[j] == 0) {
                    cnt ++;
                }
                if (cnt == idx) {
                    arr[j] = i + 1;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}