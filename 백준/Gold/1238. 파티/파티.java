import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int x;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 마을의 갯수 + 1 만큼 리스트 선언
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, f));
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int total = findShortcut(i, x) + findShortcut(x, i);
            max = Math.max(max, total);
        }
        bw.write(max + "");
        br.close();
        bw.close();
    }

    public static int findShortcut(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[n+1];
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.num;
            int nowDist = current.fee;

            if(distance[now] < nowDist) continue;

            for(Node next : graph.get(now)){
                int cost = nowDist + next.fee;
                if (cost < distance[next.num]) {
                    distance[next.num] = cost;
                    pq.offer(new Node(next.num, cost));
                }
            }
        }
        return distance[end];
    }

    static class Node implements Comparable<Node>{
        int num;
        int fee;

        Node(int num, int fee){
            this.num = num;
            this.fee = fee;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.fee, o.fee);
        }
    }

}
