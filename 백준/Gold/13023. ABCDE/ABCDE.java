import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int ans = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start); // 양방향 그래프
        }

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1); // 현재 노드부터 시작, 깊이는 1
            visited[i] = false;
            if (ans == 1) break; // 관계가 존재하면 바로 종료
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    static public void dfs(int node, int depth) {
        if (depth == 5) { // 깊이가 5라면 A-B-C-D-E 관계가 존재함
            ans = 1;
            return;
        }

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
