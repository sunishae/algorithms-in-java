import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] parent;

    // x의 루트 찾기
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 이렇게 써야 경로 압축이 됨
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[a] = b;

    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (flag == 1) {
                if(find(a) == find(b)) bw.write("YES\n");
                else bw.write("NO\n");
            } else{
                union(find(a), find(b));
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}
