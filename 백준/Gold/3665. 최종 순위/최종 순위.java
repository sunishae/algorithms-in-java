import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] rank;
    static boolean[][] adj;
    static int[] inDegree;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            rank = new int[N + 1];
            adj = new boolean[N + 1][N + 1];
            inDegree = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    int u = rank[i];
                    int v = rank[j];
                    adj[u][v] = true;
                    inDegree[v]++;
                }
            }

            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                swap(u, v);
            }

            bw.write(topology() + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void swap(int u, int v) {
        if (adj[u][v]) {
            adj[u][v] = false;
            adj[v][u] = true;
            inDegree[v]--;
            inDegree[u]++;
        } else {
            adj[v][u] = false;
            adj[u][v] = true;
            inDegree[u]--;
            inDegree[v]++;
        }
    }

    static String topology() {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (q.isEmpty()) {
                return "IMPOSSIBLE";
            }

            if (q.size() > 1) {
                return "?";
            }

            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int j = 1; j <= N; j++) {
                if (adj[cur][j]) {
                    adj[cur][j] = false;
                    inDegree[j]--;
                    if(inDegree[j] == 0){
                        q.offer(j);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}