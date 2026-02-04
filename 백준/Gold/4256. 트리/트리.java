import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] preArr;
    static int[] inArr;
    static StringBuilder sb;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            preArr = new int[n];
            for (int i = 0; i < n; i++) preArr[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            inArr = new int[n];
            for (int i = 0; i < n; i++) inArr[i] = Integer.parseInt(st.nextToken());

            postOrder(0, 0, n - 1);

            System.out.println(sb.toString().trim());
        }
    }

    public static void postOrder(int preStart, int inStart, int inEnd) {
        if (preStart >= n || inStart > inEnd) return;

        int root = preArr[preStart];
        int rootIdx = -1;

        for (int i = inStart; i <= inEnd; i++) {
            if (inArr[i] == root) {
                rootIdx = i;
                break;
            }
        }

        if (rootIdx == -1) return;

        int leftSize = rootIdx - inStart;

        postOrder(preStart + 1, inStart, rootIdx - 1);
        postOrder(preStart + leftSize + 1, rootIdx + 1, inEnd);

        sb.append(root).append(" ");
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}