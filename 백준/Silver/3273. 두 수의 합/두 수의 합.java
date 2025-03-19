import java.io.*;
import java.util.*;

public class Main {

    static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine()); // 타겟 넘버

        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        int cnt = 0;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == x) {
                cnt++;
                left++;
                right--;
            }
            else if(sum < x) left++;
            else right--;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
