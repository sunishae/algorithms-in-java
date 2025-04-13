import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] pointed;
    static int[] time;
    static int[] resultTime;
    static ArrayList<ArrayList<Integer>> graph;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            pointed = new int[n + 1];
            time = new int[n + 1];
            resultTime = new int[n + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                resultTime[i] = time[i]; // 초기 시간 설정
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                pointed[v]++;
            }

            int dist = Integer.parseInt(br.readLine());
            bw.write(topology(dist) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int topology(int dist) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (pointed[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                resultTime[next] = Math.max(resultTime[next], resultTime[cur] + time[next]);
                pointed[next]--;

                if (pointed[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return resultTime[dist];
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
