import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int min;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, int depth) {
        if (depth == N/2) {
            cal();
            return;
        }
        for (int i = start; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void cal() {
        int start_team = 0;
        int link_team = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start_team += board[i][j];
                    start_team += board[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    link_team += board[i][j];
                    link_team += board[j][i];
                }
            }
        }

        int result = Math.abs(start_team - link_team);

        if(result == 0){
            System.out.println('0');
            System.exit(0);
        }

        min = Math.min(min, result);
    }



    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
