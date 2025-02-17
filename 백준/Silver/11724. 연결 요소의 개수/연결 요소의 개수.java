import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

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

        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int start, end;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                ans++;
            }
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int index) {
        visited[index] = true;
        for(int i : graph.get(index)) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
