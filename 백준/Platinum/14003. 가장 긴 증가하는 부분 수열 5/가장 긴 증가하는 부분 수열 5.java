import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    // index[i] : A[i]가 LIS의 몇 번째 원소에 해당하는지 (길이)
    static int[] index;
    // list : 길이가 i인 LIS의 마지막 원소 중 가장 작은 값을 저장
    static ArrayList<Integer> list = new ArrayList<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        index = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 원소 초기화
        list.add(A[0]);
        index[0] = 0;

        for (int i = 1; i < N; i++) {
            if (list.get(list.size() - 1) < A[i]) {
                // A[i]가 LIS의 마지막 원소보다 크면, LIS에 추가
                list.add(A[i]);
                index[i] = list.size() - 1;
            } else {
                // 이진 탐색으로 A[i]가 들어갈 위치(lo)를 찾음
                int lo = 0;
                int hi = list.size() - 1;

                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if (list.get(mid) < A[i]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }

                list.set(lo, A[i]);
                index[i] = lo;
            }
        }

        bw.write(list.size() + "\n");

        // 역추적
        Stack<Integer> result = new Stack<>();
        int currentLen = list.size() - 1;

        for (int i = N - 1; i >= 0; i--) {
            if (index[i] == currentLen) {
                result.push(A[i]);
                currentLen--;
            }
        }

        // 스택을 뒤집어 출력
        while (!result.isEmpty()) {
            bw.write(result.pop() + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}
