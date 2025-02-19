import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static boolean[] visited = new boolean[100001];
    static int[] arr = new int[100001];
    static Queue<Integer> q = new LinkedList<>();
    static int[] dx = {-1, 1, 2};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        q.offer(n);
        visited[n] = true;
        int next;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == k) break;

            for (int i = 0; i < 3; i++) {
                if(i == 2)
                    next = current * 2;
                else
                    next = current + dx[i];

                if (next < 0 || next > 100000) continue;
                if (visited[next]) continue;

                visited[next] = true;
                arr[next] = Math.max(arr[current] + 1, arr[next]);
                q.offer(next);
            }
        }

        bw.write(arr[k] + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
