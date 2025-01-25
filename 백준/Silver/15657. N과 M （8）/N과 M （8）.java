import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] out;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        arr = new int[N];
        out = new int[M];
        visit = new boolean[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0);

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : out) {
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) { // M → N으로 수정
            if (!visit[i]) {
//                visit[i] = true;
                out[depth] = arr[i];
                dfs(start, depth + 1);
                start++;
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
