import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(0, 0, N));
    }

    public static int solve(int r, int c, int size) {
        if (size == 2) {
            int[] temp = new int[4];
            temp[0] = arr[r][c];
            temp[1] = arr[r][c + 1];
            temp[2] = arr[r + 1][c];
            temp[3] = arr[r + 1][c + 1];
            Arrays.sort(temp);
            return temp[2];
        }

        int half = size / 2;
        int[] results = new int[4];
        results[0] = solve(r, c, half);               // 왼쪽 위
        results[1] = solve(r, c + half, half);        // 오른쪽 위
        results[2] = solve(r + half, c, half);        // 왼쪽 아래
        results[3] = solve(r + half, c + half, half); // 오른쪽 아래

        Arrays.sort(results);
        return results[2]; 
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}