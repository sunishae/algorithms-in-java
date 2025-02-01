import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(new int[n], 0);
        System.out.println(max);
    }

    static void dfs(int[] permutation, int depth) {
        if (depth == n) {
            // 순열이 완성되었으므로 계산
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(permutation[i] - permutation[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = arr[i];
                dfs(permutation, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
