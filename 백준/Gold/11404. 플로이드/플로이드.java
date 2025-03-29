import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 987654321; // 여기서 오류 발생 가능성1
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[u][v] = Math.min(weight, graph[u][v]);
        }

        floyd();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == 987654321)
                    bw.write("0 ");
                else
                    bw.write(graph[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void floyd() {
        for (int k = 1; k <= n; k++) {
            // 노드 i에서 j로 가는 경우.
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    // 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
