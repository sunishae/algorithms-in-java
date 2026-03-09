import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] pointed;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pointed = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            pointed[v]++;
        }

        topology();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void topology() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (pointed[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                pointed[next]--;
                if (pointed[next] == 0) {
                    pq.add(next);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}