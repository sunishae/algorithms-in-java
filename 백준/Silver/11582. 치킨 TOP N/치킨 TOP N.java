import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr, sorted;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        merge_sort(0, N - 1);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void merge_sort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        merge_sort(left, mid);
        merge_sort(mid + 1, right);

        if (right - left + 1 <= N / K) {
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) sorted[idx++] = arr[l++];
            else sorted[idx++] = arr[r++];
        }

        while (l <= mid) sorted[idx++] = arr[l++];
        while (r <= right) sorted[idx++] = arr[r++];

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}