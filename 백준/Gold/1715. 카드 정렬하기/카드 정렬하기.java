import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            int n3 = n1 + n2;
            pq.add(n3);
            ans += n1 + n2;
        }
        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
