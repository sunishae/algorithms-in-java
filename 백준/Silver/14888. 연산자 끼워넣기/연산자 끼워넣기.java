import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int start, end;
    static int[] op = new int[4];
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 숫자 갯수
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    public static void dfs(int idx, int depth) {
        if (depth == n) {
            max = Math.max(max, idx);
            min = Math.min(min, idx);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] > 0){
                op[i]--;

                switch(i){
                    case 0: dfs(idx + num[depth], depth + 1); break;
                    case 1: dfs(idx - num[depth], depth + 1); break;
                    case 2: dfs(idx * num[depth], depth + 1); break;
                    case 3: dfs(idx / num[depth], depth + 1); break;
                }

                op[i]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}