import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        long ans = 0;
        for (int i = 1; i <= N; i++) {
            int cur = list.get(i - 1);
            ans += Math.abs(cur - i);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}