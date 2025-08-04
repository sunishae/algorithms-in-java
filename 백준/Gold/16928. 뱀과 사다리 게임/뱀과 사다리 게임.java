import java.io.*;
import java.util.*;

public class Main {
    static final int SIZE = 101;
    static int n, m;
    static int[] map;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[SIZE];

        for (int i = 1; i < SIZE; i++) {
            map[i] = i;
        }

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u] = v; // 사다리나 뱀
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[SIZE];
        Arrays.fill(dist, -1);

        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                next = map[next]; // 사다리 or 뱀 이동
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        bw.write(dist[100] + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
