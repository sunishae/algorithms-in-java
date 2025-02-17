import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static boolean[][] map;
    static int cnt = 0;
    static int num = 0;
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }

        // 단지 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    num = 0;
                    dfs(i, j);
                    cnt++;
                    list.add(num);
                }
            }
        }

        // 출력
        System.out.println(cnt);
        Collections.sort(list);
        for (int size : list) {
            System.out.println(size);
        }
    }

    static void dfs(int x, int y) {
        map[x][y] = false; // 방문 처리
        num++; // 집 크기 증가

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            // 범위 체크 및 미방문 노드 탐색
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
