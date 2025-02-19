import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static boolean[] visited = new boolean[100001];
    static int[][] arr = new int[2][100001];
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
        arr[1][n] = -1;
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
                arr[0][next] = arr[0][current] + 1;
                arr[1][next] = current;
                q.offer(next);
            }
        }

        int cur = k;
        Stack<Integer> stack = new Stack<>();
        while (arr[1][cur] != -1) {
            stack.add(cur);
            cur = arr[1][cur];
        }
        stack.add(cur);

        bw.write(arr[0][k] + "\n");
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
