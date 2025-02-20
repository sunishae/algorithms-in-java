import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited = new boolean[1001][1001];//[clipboard][total]

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(br.readLine());

        bfs(s);

        bw.flush();
        bw.close();
    }

    public static void bfs(int s) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        visited[0][1] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();

            if(current.total == s) {
                System.out.println(current.time);
                return;
            }

            // 1. 화면에 있는 이모티콘 클립보드에 저장
            q.offer(new Node(current.total, current.total, current.time + 1));


            // 2. 클립보드에 있는 이모티콘 붙여넣기.
            // 클립보드 비어있지 않아야하고, 붙여넣은 후 개수가 총 개수보다 적어야 하며, 이전에 방문한적 없어야함.
            if(current.clipboard != 0 && current.total + current.clipboard <= s && !visited[current.clipboard][current.total + current.clipboard]) {
                q.offer(new Node(current.clipboard, current.total + current.clipboard, current.time + 1));
                visited[current.clipboard][current.total + current.clipboard] = true;
            }

            // 3. 화면에 있는 이모티콘 중 하나 삭제.
            // 총 개수 1보다 크거나 같아야하고, 방문한적 없어야함.
            if(current.total >= 1 && !visited[current.clipboard][current.total - 1]) {
                q.offer(new Node(current.clipboard, current.total - 1, current.time + 1));
                visited[current.clipboard][current.total - 1] = true;
            }
        }
    }

    public static class Node {
        int clipboard;
        int total;
        int time;

        public Node(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
