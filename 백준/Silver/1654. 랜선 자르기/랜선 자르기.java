import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int n;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];

        long max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        max++;

        long min = 0;
        long mid = 0 ;

        while(min < max) {
            mid = (min + max) / 2;
            long cnt = 0;

            for (int i = 0; i < arr.length; i++) {
                cnt += (arr[i]/mid);
            }

            if (cnt < n) {
                max = mid;
            }
            else{
                min = mid + 1;
            }

        }
        bw.write((min - 1) + "");

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
