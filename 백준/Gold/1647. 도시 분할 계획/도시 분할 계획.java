import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Node> nodeList = new ArrayList<>();
    static int[] parent;

    public static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(u, v, n));
        }

        Collections.sort(nodeList);

        long sum = 0;
        int cnt = 0;
        int maxCost = 0;

        for (Node node : nodeList) {
            if (union(node.from, node.to)) {
                sum += node.cost;
                maxCost = Math.max(maxCost, node.cost);
                cnt++;

                if (cnt == N - 1) break;
            }
        }

        // 가장 비용이 큰 간선 하나를 제거
        sum -= maxCost;

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int find(int node) {
        if (parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    public static boolean union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);

        if (fromParent == toParent) return false;
        else parent[toParent] = fromParent;
        return true;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
