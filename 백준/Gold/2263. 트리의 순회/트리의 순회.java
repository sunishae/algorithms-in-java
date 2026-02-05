import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] inArr;
    static int[] postArr;
    static StringBuilder sb = new StringBuilder();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        inArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inArr[i] = Integer.parseInt(st.nextToken());
        }

        postArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postArr[i] = Integer.parseInt(st.nextToken());
        }

        preOrder(n - 1, 0, n - 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void preOrder(int postEnd, int inStart, int inEnd) {
        if(postEnd < 0 || inStart > inEnd) return;

        int root = postArr[postEnd];
        int rootIdx = -1;

        for (int i = inStart; i <= inEnd; i++) {
            if (inArr[i] == root) {
                rootIdx = i;
                break;
            }
        }

        int rightsize = inEnd - rootIdx;

        sb.append(root).append(" ");
        preOrder(postEnd - rightsize - 1, inStart, rootIdx - 1);
        preOrder(postEnd - 1, rootIdx + 1, inEnd);

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}