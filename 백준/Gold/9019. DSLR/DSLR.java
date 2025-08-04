import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    static class Register{
        int num;
        String command;

        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D(){
            return (num * 2) % 10000;
        }
        int S() {
            return num == 0 ? 9999 : num - 1;
        }
        int L() {
            return num % 1000 * 10 + num / 1000;
        }
        int R() {
            return num % 10 * 1000 + num / 10;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];

            Queue<Register> q = new LinkedList<>();
            q.offer(new Register(start, ""));

            while (!q.isEmpty()) {
                Register cur = q.poll();

                if (cur.num == end) {
                    sb.append(cur.command).append("\n");
                    break;
                }

                if (!visited[cur.D()]) {
                    q.offer(new Register(cur.D(), cur.command + "D"));
                    visited[cur.D()] = true;
                }
                if (!visited[cur.S()]) {
                    q.offer(new Register(cur.S(), cur.command + "S"));
                    visited[cur.S()] = true;
                }
                if (!visited[cur.L()]) {
                    q.offer(new Register(cur.L(), cur.command + "L"));
                    visited[cur.L()] = true;
                }
                if (!visited[cur.R()]) {
                    q.offer(new Register(cur.R(), cur.command + "R"));
                    visited[cur.R()] = true;
                }
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
