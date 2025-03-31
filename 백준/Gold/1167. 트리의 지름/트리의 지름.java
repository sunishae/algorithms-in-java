import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static int[] wLength;
    static int maxIndex;
    static int maxWeight = 0;

    static class Node {
        int num;
        int weight;
        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        wLength = new int[n + 1];
        for (int i = 0; i <=n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 1; i <=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while(true){
                int v = Integer.parseInt(st.nextToken());
                if(v == -1)
                    break;

                int weight = Integer.parseInt(st.nextToken());
                tree.get(u).add(new Node(v, weight));
            }
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
                if (!visited[node.num]) {
                    visited[node.num] = true;
                    queue.add(node.num);
                    wLength[node.num] = wLength[cur] + node.weight;
                    if (wLength[node.num] > maxWeight) {
                        maxWeight = wLength[node.num];
                        maxIndex = node.num;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
