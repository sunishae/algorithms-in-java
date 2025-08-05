import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static int max;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        HashSet<Character> set = new HashSet<>();
        set.add(map[0][0]);
        DFS(0, 0,1, set);

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void DFS(int x, int y, int cnt, HashSet<Character> set){
        max = Math.max(cnt, max);
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
            char nextChar = map[nextX][nextY];
            if (set.contains(nextChar)) continue;

            set.add(nextChar);
            DFS(nextX, nextY, cnt + 1, set);
            set.remove(nextChar); // 백트래킹
        }
    }




    public static void main(String[] args) throws IOException {
        solution();
    }
}
