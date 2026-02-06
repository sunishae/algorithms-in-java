import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static int B,C;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long cnt = 0;
        for (int i = 0; i < N; i++) {
            // 총감독
            A[i] -= B;
            cnt += 1;

            if (A[i] < 0) {
                A[i] = 0;
            }

            // 부감독
            if (A[i] % C == 0) {
                cnt += A[i] / C;
            } else {
                cnt += A[i] / C;
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}