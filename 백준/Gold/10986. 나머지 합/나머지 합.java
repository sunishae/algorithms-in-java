import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] mod;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        long result = 0;
        long[] cnt = new long[m];

        mod = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            mod[i] = (mod[i - 1] + Integer.parseInt(st.nextToken())) % m;
            if(mod[i] == 0) result++;
            cnt[mod[i]]++;
        }

        for (int i = 0; i < m; i++) {
            if(cnt[i] > 1){
                result += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }


        bw.write(result + "");
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
