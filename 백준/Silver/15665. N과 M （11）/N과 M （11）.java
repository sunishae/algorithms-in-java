import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static ArrayList<Integer> list;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(list.contains(x)) continue;
            list.add(x);
        }

        Collections.sort(list);
        dfs(0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void dfs(int depth){
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            arr[depth] = list.get(i);
            dfs(depth + 1);
        }

    }
}
