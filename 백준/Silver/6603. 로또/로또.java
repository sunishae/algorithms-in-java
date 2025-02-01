import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr = new int[13];
    static int[] result = new int[6];
    static boolean[] visit = new boolean[13];
    static StringBuilder sb = new StringBuilder();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if(depth == 6){
            int i = 0;
            while(i < 5 && result[i] < result[i+1]) i++;
            if(i < 5) return;
            for(int val : result){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(start+1, depth + 1);
                visit[i] = false;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
