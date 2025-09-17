import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt((br.readLine()));
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(check(S, E)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static int check(int i, int j) {
        if (i == j) {
            return 1;
        }

        while (i < j) {
//            System.out.println("(i,j) : " + arr[i] + " " + arr[j]);
            if(arr[i++] != arr[j--]) return 0;
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
