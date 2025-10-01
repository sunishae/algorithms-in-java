import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] parent;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int cnt = 1;
        boolean flag = false;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            u = find(u);
            v = find(v);

            if (u != v) {
                cnt++;
                join(u, v);
            } else {
                flag = true;
                break;
            }
        }

        if(flag) bw.write(cnt + "\n");
        else bw.write("0\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void join(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
