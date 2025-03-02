import java.io.*;
import java.util.*;

public class Main {
    static int n; // 도시의 개수
    static int m; // 버스의 개수
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    static class Node {
        int num;
        int fee;

        Node(int num, int fee) {
            this.num = num;
            this.fee = fee;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        distance = new int[n+1];
        for(int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[n+1];

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            Node node = new Node(v, fee);
            list.get(u).add(node);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = findShortcut(start, end);
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static int findShortcut(int start, int end){
        distance[start] = 0;

        for (int i = 0; i < n; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && distance[j] < nodeValue) {
                    nodeValue = distance[j];
                    nodeIdx = j;
                }
            }

            visited[nodeIdx] = true;
            for(int j = 0; j < list.get(nodeIdx).size(); j++){
                Node adjNode = list.get(nodeIdx).get(j);
                if (distance[adjNode.num] > distance[nodeIdx] + adjNode.fee) {
                    distance[adjNode.num] = distance[nodeIdx] + adjNode.fee;
                }
            }
        }
        return distance[end];
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
