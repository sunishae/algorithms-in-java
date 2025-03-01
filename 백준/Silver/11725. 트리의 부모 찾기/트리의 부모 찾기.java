import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <=n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        bfs(1);

        for (int i = 2; i <= n; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int index) {
        Queue<Integer>q = new LinkedList<>();

        q.add(index);
        visited[index] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int i : tree.get(cur)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    parent[i] = cur;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
