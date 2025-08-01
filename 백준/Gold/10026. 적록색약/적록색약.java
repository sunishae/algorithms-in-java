import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] origin;
    static char[][] blind;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        origin = new char[N][N];
        blind = new char[N][N];

        for (int i = 0; i < N; i++) {
            origin[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(origin[i][j] == 'G'){
                    blind[i][j] = 'R';
                } else blind[i][j] = origin[i][j];
            }
        }

        bw.write(BFS(origin) + " " + BFS(blind));
        bw.flush();
        bw.close();
    }

    public static int BFS(char[][] arr) {
        boolean[][] visited = new boolean[N][N];

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    result++;
                    Queue<Point> q = new LinkedList<>();
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    char curColor = arr[i][j];

                    while (!q.isEmpty()) {
                        Point curPoint = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextX = curPoint.x + dx[k];
                            int nextY = curPoint.y + dy[k];
                            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                                continue;
                            if(arr[nextX][nextY] != curColor) continue;
                            if(visited[nextX][nextY]) continue;
                            q.offer(new Point(nextX, nextY));
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException{
        solution();
    }
}
