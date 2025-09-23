import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] a;
    static long[] maxTree;
    static long[] minTree;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new long[N];

        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(br.readLine());
        }

        int h = (int)Math.ceil(Math.log(N) / Math.log(2));
        int tree_size = (1 << (h + 1));
        maxTree = new long[tree_size];
        minTree = new long[tree_size];

        max_init(1, 0, N - 1);
        min_init(1, 0, N - 1);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            long minVal = min_query(1, 0, N - 1, start - 1, end - 1);
            long maxVal = max_query(1, 0, N - 1, start - 1, end - 1);

            bw.write(minVal + " " + maxVal + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void max_init(int node, int start, int end) {
        if (start == end) {
            maxTree[node] = a[start];
        } else {
            max_init(node * 2, start, (start + end) / 2);
            max_init(node * 2 + 1, (start + end) / 2 + 1, end);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        }
    }

    public static void min_init(int node, int start, int end) {
        if (start == end) {
            minTree[node] = a[start];
        } else {
            min_init(node * 2, start, (start + end) / 2);
            min_init(node * 2 + 1, (start + end) / 2 + 1, end);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }
    }

    public static long max_query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Long.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }
        long l = max_query(node * 2, start, (start + end) / 2, left, right);
        long r = max_query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.max(l, r);
    }

    public static long min_query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Long.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return minTree[node];
        }
        long l = min_query(node * 2, start, (start + end) / 2, left, right);
        long r = min_query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.min(l, r);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
