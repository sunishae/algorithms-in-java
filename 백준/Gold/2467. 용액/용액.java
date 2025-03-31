import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int a,b;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPoint();

        bw.write(a + " " + b + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void twoPoint() {
        int left = 0;
        int right = n-1;

        while (left < right) {
            int o1 = arr[left];
            int o2 = arr[right];
            int value = Math.abs(o1+o2);
            if (Math.abs(min) >= value) {
                min = value;
                a = arr[left];
                b = arr[right];
            }

            if(Math.abs(o1) < Math.abs(o2)){
                right--;
            } else
                left++;
        }

    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
