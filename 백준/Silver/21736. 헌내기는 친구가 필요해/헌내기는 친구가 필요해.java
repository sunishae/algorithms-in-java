import java.io.*;
import java.util.*;

public class Main {
    static int N; // 행
    static int M; // 열
    static int cnt;
    static char[][] campus;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine().toCharArray();
            if(q.isEmpty()) {
                for (int j = 0; j < M; j++) {
                    if(campus[i][j] == 'I'){
                        q.offer(new Point(i, j));
                        visited[i][j] = true;
                        break;
                    }
                }
            }
        }

        cnt = 0;
        BFS();

        bw.write(cnt == 0 ? "TT\n" : cnt + "\n");
        bw.flush();
        bw.close();
    }

    public static void BFS() {
        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (campus[nextX][nextY] == 'X') continue;
                if (visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                q.offer(new Point(nextX, nextY));
                if(campus[nextX][nextY] == 'P') cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        solution();
    }
}
