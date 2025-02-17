import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int v;
    static int e;
    static final int RED = 1;
    static final int BLUE = -1;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors; // 색 {RED 1 or BLUE -1}
    static boolean checkBipartite; // 이분 그래프인지 아닌지 확인


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            colors = new int[v + 1];
            checkBipartite = true;
            graph = new ArrayList<>();

            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            int start, end;
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            for(int i = 1; i < v+1; i++){
                if(!checkBipartite){
                    break;
                }
                if(colors[i] == 0){
                    dfs(i, RED);
                }
            }
            System.out.println(checkBipartite ? "YES" : "NO");
        }
    }

    static void dfs(int index, int color) {
        colors[index] = color;
        for(int adjV : graph.get(index)) {
            if (colors[adjV] == color) {
                checkBipartite = false;
                return;
            }

            if(colors[adjV] == 0) {
                dfs(adjV, -color);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
