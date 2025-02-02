import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n; // 배열 크기
    static int s; // 타겟 합
    static int[] arr;
    static int cnt = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st1.nextToken());
        s = Integer.parseInt(st1.nextToken());
        arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(0, 0);

        if( s==0) cnt--;


        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                cnt++;
            }
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
