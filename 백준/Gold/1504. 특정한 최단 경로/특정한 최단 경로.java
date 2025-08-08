import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 200000000;
    static int N;
    static int M;
    static ArrayList<ArrayList<Node>> graph;

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, weight));
            graph.get(v).add(new Node(u, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int first = 0;
        first += dijkstra(1, v1);
        first += dijkstra(v1, v2);
        first += dijkstra(v2, N);

        int second = 0;
        second += dijkstra(1, v2);
        second += dijkstra(v2, v1);
        second += dijkstra(v1, N);

        int result = (first >= INF && second >= INF) ? -1 : Math.min(first, second);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int cur = now.v;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node next : graph.get(cur)) {
                    if (!visited[next.v] && dist[next.v] > dist[cur] + next.cost) {
                        dist[next.v] = dist[cur] + next.cost;
                        q.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
        return dist[end];
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}
