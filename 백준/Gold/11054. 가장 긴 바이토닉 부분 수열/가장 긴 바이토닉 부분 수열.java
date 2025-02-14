import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] increase = new int[n];
        int[] decrease = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            increase[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { // 증가하는 수열 조건
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            decrease[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) { // 감소하는 수열 조건
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, increase[i] + decrease[i]);
        }

        bw.write(max -1 + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
