import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] budget;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budget);

        M = Integer.parseInt(br.readLine());

        int low = 1;
        int high = budget[budget.length - 1];
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (cal(mid) <= M) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int cal(int b) {
        int sum = 0;
        for (int i = 0; i < budget.length; i++) {
            if (budget[i] <= b) {
                sum += budget[i];
            } else {
                sum += b;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}