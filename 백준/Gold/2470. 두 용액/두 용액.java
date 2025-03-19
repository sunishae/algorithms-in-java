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

        Arrays.sort(arr);  // 정렬 필수

        int a = 0, b = 0;
        int left = 0, right = n - 1;
        int min = Integer.MAX_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < min) {  // 최소값 갱신
                min = Math.abs(sum);
                a = arr[left];
                b = arr[right];

                if (min == 0) break;  // 합이 0이면 최적해이므로 바로 종료
            }

            if (sum < 0) {  // 합이 음수면 더 큰 값 필요 → left 증가
                left++;
            } else {  // 합이 양수면 더 작은 값 필요 → right 감소
                right--;
            }
        }

        // 항상 a가 작은 값이 되도록 정렬
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        bw.write(a + " " + b);
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
