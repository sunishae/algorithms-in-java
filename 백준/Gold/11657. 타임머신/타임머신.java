import java.util.*;
import java.io.*;

class Main{
    static final long INF = Long.MAX_VALUE;
    static long[] distance;
    static int n;
    static int m;
    static ArrayList<ArrayList<Edge>> graph;

    static class Edge{
        int num;
        int weight;

        public Edge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new long[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, weight));
        }

        StringBuilder sb = new StringBuilder();
        if (!bellmanFord(1)) {
            sb.append("-1\n");
        } else{
            for (int i = 2; i <= n; i++) {
                if(distance[i] == INF){
                    sb.append("-1\n");
                } else{
                    sb.append(distance[i]).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


    public static boolean bellmanFord(int idx) {
        distance[idx] = 0;

        // 1 ~ n-1번까지 모든 간선 완화
        for (int i = 0; i < n - 1; i++) {
            for (int u = 1; u <= n; u++) {
                if (distance[u] == INF) continue;

                for (Edge e : graph.get(u)) {
                    if (distance[e.num] > distance[u] + e.weight) {
                        distance[e.num] = distance[u] + e.weight;
                    }
                }
            }
        }

        // 음수 사이클 검사
        for (int u = 1; u <= n; u++) {
            if (distance[u] == INF) continue;

            for (Edge e : graph.get(u)) {
                if (distance[e.num] > distance[u] + e.weight) {
                    return false; // 음수 사이클 존재
                }
            }
        }

        return true;
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}