import java.io.*;
import java.util.*;

public class Main {
    static int a,b;
    static int result = -1;

    static class Node{
        long data;
        int level;

        Node(long data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bfs(a);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        Node root = new Node(start, 1);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.data == b) {
                result = cur.level;
                break;
            }
            if(cur.data > b) continue;
            Node node1 = new Node((cur.data) * 2, cur.level + 1);
            Node node2 = new Node((cur.data) * 10 + 1, cur.level + 1);
            q.add(node1);
            q.add(node2);
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
