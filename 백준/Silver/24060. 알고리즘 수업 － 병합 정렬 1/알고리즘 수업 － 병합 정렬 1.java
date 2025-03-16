import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int cnt = 0;
    static int result = -1;
    static int[] arr;
    static int[] tmp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tmp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 병합 정렬 실행
        merge_sort(0, n - 1);

        // K번째 저장된 값을 출력
        bw.write(result + "\n");

        br.close();
        bw.close();
    }

    public static void merge_sort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        merge_sort(left, mid);
        merge_sort(mid + 1, right);

        merge(left, mid, right);
    }

    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tmp[idx++] = arr[l++];
            } else {
                tmp[idx++] = arr[r++];
            }
        }

        while (l <= mid) {
            tmp[idx++] = arr[l++];
        }

        while (r <= right) {
            tmp[idx++] = arr[r++];
        }

        // 병합된 데이터 arr에 다시 복사하면서 K번째 저장 확인
        for (int i = left; i <= right; i++) {
            cnt++;
            arr[i] = tmp[i];

            if (cnt == k) {
                result = arr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
