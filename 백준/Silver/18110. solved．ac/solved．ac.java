import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.util.Arrays.sort;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        int new_n = (int) Math.round(n * 0.15);
        int count = n - new_n * 2;

        if (count == 0) {
            System.out.println(0);
            return;
        }
        sort(arr);

        double sum = 0;
        for (int i = new_n; i < n - new_n; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round(sum / count));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
