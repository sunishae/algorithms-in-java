import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int cnt = 1;
    static BufferedWriter bw;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        visited = new int[n + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(r);
        for (int i = 1; i <= n; i++) {
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int r) throws IOException {
        visited[r] = cnt++;

        for (int next : graph.get(r)) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}