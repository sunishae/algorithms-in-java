import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int start, end;
    static boolean[][] graph;
    static boolean[] visited;
    static int m;

    public static class Node {
        int vertex;
        int cnt;

        public Node(int vertex, int cnt) {
            this.vertex = vertex;
            this.cnt = cnt;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        graph = new boolean[101][101];
        visited = new boolean[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = true;
            graph[v][u] = true;
        }

        bw.write(search() + "");
        bw.flush();
        bw.close();
    }

    public static int search() {
        int cnt = 0;
        boolean flag = false;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(start, 0));
        visited[start] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.vertex == end) {
                flag = true;
                cnt = cur.cnt;
                break;
            }

            for (int i = 1; i <= n; i++) {
                if (graph[cur.vertex][i] && !visited[i]) {
                    q.add(new Node(i, cur.cnt + 1));
                    visited[i] = true;
                }
            }
        }

        if (flag) {
            return cnt;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
