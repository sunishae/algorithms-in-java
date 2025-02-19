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
    static int[] dx = {-1, 1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == k) break;

            // 순간이동 (*2) 먼저 처리
            int next = current * 2;
            if (next <= 100000 && !visited[next]) {
                visited[next] = true;
                arr[next] = arr[current]; // 0초이므로 그대로 유지
                q.offer(next); // 먼저 처리하기 위해 offer() 사용
            }

            // 걷기 (-1, +1)
            for (int i = 0; i < 2; i++) {
                next = current + dx[i];
                if (next < 0 || next > 100000) continue;
                if (visited[next]) continue;

                visited[next] = true;
                arr[next] = arr[current] + 1; // 1초 걸림
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
