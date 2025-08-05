import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1}; // 위, 왼, 오, 아래
    static int[] dy = {0, -1, 1, 0};

    public static class Point {
        int x, y, dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eaten = 0;
        int time = 0;

        while (true) {
            Point nextFish = null;
            boolean[][] visited = new boolean[N][N];
            PriorityQueue<Point> pq = new PriorityQueue<>((a,b) ->{
               if (a.dist != b.dist) return a.dist - b.dist;
               if (a.x != b.x) return a.x - b.x;
               return a.y - b.y;
            });

            pq.add(new Point(startX, startY, 0));
            visited[startX][startY] = true;

            while (!pq.isEmpty()) {
                Point cur = pq.poll();

                if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < size) {
                    nextFish = cur;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] > size) continue;

                    visited[nx][ny] = true;
                    pq.add(new Point(nx, ny, cur.dist + 1));
                }
            }

            if(nextFish == null) break;

            startX = nextFish.x;
            startY = nextFish.y;
            time += nextFish.dist;
            eaten++;
            map[startX][startY] = 0;

            if(eaten == size){
                size++;
                eaten = 0;
            }

        }

        bw.write(time + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
