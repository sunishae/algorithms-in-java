import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int       N;
    public static int       M;
    public static boolean[] visit;
    public static int[]     arr;
    public static StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        dfs(0,0);
        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <N; i++) {
            if (!visit[i]) {
                arr[depth] = i+1;
                dfs(start, depth+1);
                start++;
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
