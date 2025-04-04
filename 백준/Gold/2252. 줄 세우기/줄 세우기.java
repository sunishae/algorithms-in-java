import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] pointed;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pointed = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v); // 방향성 그래프 노드 추가
            pointed[v]++; // 지목된 수 증가
        }

        topology();

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void topology() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (pointed[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                pointed[next]--;
                if(pointed[next] == 0){
                    q.offer(next);
                }
            }
        }

    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
