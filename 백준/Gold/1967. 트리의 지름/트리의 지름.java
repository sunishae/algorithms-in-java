import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static int[] wLength;
    static int maxIndex;
    static int maxWeight = 0;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        wLength = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree.get(u).add(new Node(v, w));
            tree.get(v).add(new Node(u, w));
        }

        bfs(1);
        bfs(maxIndex);
        bw.write(maxWeight + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(wLength, 0);

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node node : tree.get(cur)) {
                if (!visited[node.to]) {
                    visited[node.to] = true;
                    queue.add(node.to);
                    wLength[node.to] = wLength[cur] + node.weight;
                    if (wLength[node.to] > maxWeight) {
                        maxWeight = wLength[node.to];
                        maxIndex = node.to;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
