import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Point> chickens = new ArrayList<>();
    static List<Point> houses = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    static public class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new Point(i, j));
                else if (map[i][j] == 2) chickens.add(new Point(i, j));
            }
        }

        comb(0, new ArrayList<>());

        System.out.println(result);
    }

    public static void comb(int idx, List<Point> selected) {
        if (selected.size() == M) {
            result = Math.min(result, calculateDistance(selected));
            return;
        }

        if (idx == chickens.size()) return;

        // 현재 치킨집 선택
        selected.add(chickens.get(idx));
        comb(idx + 1, selected);
        selected.remove(selected.size() - 1);

        // 현재 치킨집 선택하지 않음
        comb(idx + 1, selected);
    }

    // 선택된 M개의 치킨집으로부터 각 집까지의 최소 거리 계산
    public static int calculateDistance(List<Point> selected) {
        int total = 0;

        for (Point house : houses) {
            int minDist = Integer.MAX_VALUE;
            for (Point chicken : selected) {
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                minDist = Math.min(minDist, dist);
            }
            total += minDist;
        }

        return total;
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}
