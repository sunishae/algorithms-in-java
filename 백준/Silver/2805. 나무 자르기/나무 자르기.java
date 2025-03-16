import java.io.*;
import java.util.*;

public class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무 개수
        int k = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]); // 가장 긴 나무 높이 저장
        }

        int min = 0;
        int answer = 0; // 최적 절단기 높이 저장

        while (min <= max) {
            int mid = (min + max) / 2; // 절단기 높이 후보
            long len = 0; // long으로 변경 (큰 값 방지)

            // 나무를 mid 높이로 잘랐을 때의 나무 길이 합
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    len += arr[i] - mid;
                }
            }

            // 충분한 나무를 얻었으면 절단기 높이를 더 높여 본다.
            if (len >= k) {
                answer = mid; // 최적의 절단기 높이 저장
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        bw.write(answer + "\n"); // 최적의 H 값 출력
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
