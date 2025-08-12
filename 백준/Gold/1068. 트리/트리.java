import java.io.*;
import java.util.*;

public class Main {
    static int N;       // 1 ~ 50
    static int del;
    static int ans;
    static ArrayList<ArrayList<Integer>> node;
    static int[] parent;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        node = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            node.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            parent[i] = n + 1;
            if (n == -1) root = i;  // 루트 기억
            else node.get(n + 1).add(i);
        }

        del = Integer.parseInt(br.readLine()) + 1;

        if (del == root) { // 루트 삭제이면
            bw.write("0\n");
            bw.flush();
            return;
        }

        node.get(parent[del]).remove((Integer) del);

        ans = 0;
        dfs(root);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    public static void dfs(int cur) {
        if(node.get(cur).isEmpty()){
            ans++;
            return;
        }

        for (int next : node.get(cur)) {
            dfs(next);
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
