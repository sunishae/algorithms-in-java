import java.io.*;
import java.util.*;

public class Main {
    static int n; // 편의점 개수
    static ArrayList<Point> conv;
    static Point start, end;
    static boolean flag;
    static boolean[] visited;

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            conv = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                conv.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            flag = false;
            visited = new boolean[n];

            dfs(start);

            if (flag) {
                bw.write("happy\n");
            } else {
                bw.write("sad\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(Point cur) {
        if (flag) return;
        if (getDist(cur, end) <= 1000) {
            flag = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Point next = conv.get(i);
                if (getDist(cur, next) <= 1000) {
                    visited[i] = true;
                    dfs(next);
                }

            }
        }

    }

    public static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
