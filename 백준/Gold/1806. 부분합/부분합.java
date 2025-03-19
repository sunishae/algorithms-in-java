import java.io.*;
import java.util.*;

public class Main {

    static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (right < n){
            sum += arr[right];

            while(sum >= s){
                min = Math.min(min, right - left + 1);
                sum -= arr[left];
                left++;
            }
            right++;
        }

        if(min == Integer.MAX_VALUE) min = 0;
        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
