import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int M, N, targetX, targetY;
        int maxYear;

        // 1 ≤ M, N ≤ 40,000
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            // 최대 반복 횟수는 최소공배수
            maxYear = getLCM(M, N);

            // 찾기 로직
            boolean found = false;
            for (int k = targetX; k <= maxYear; k += M) {
                if ((k - 1) % N + 1 == targetY) {
                    bw.write(String.valueOf(k));
                    bw.newLine();
                    found = true;
                    break;
                }
            }

            // 찾지 못한 경우
            if (!found) {
                bw.write("-1");
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    // 최대공약수(GCD)
    public static int getGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return getGCD(num2, num1 % num2);
    }

    // 최소공배수(LCM)
    public static int getLCM(int num1, int num2) {
        return (num1 * num2) / getGCD(num1, num2);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
