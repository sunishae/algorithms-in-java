import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    public static void solution() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
            }
            bw.write(N - 1 + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }

}
