import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static int v;
    static int e;

    static int[] parent;
    static class Node implements Comparable<Node>{
        int to;
        int from;
        int value;

        public Node(int to, int from, int value){
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq.add(new Node(to, from, value));
        }

        int result = 0;
        for (int i = 0; i < e; i++) {
            Node current = pq.poll();
            int to = find(current.to);
            int from = find(current.from);

            if(to != from){
                result += current.value;
                union(to, from);
            }

        }

        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
