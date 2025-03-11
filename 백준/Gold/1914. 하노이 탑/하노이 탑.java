import java.io.*;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close(); // 입력 스트림 닫기

        // 2^N - 1 출력 (옮긴 횟수 K)
        System.out.println(BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE));

        // N이 20 이하일 때만 수행 과정 출력
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
            System.out.print(sb);
        }
    }

    // 하노이 탑 재귀 함수
    public static void hanoi(int n, int src, int via, int dst) {
        if (n == 1) {
            sb.append(src).append(" ").append(dst).append("\n");
        } else {
            hanoi(n - 1, src, dst, via); // N-1개를 src에서 via로 이동
            sb.append(src).append(" ").append(dst).append("\n"); // 가장 큰 원판 이동
            hanoi(n - 1, via, src, dst); // N-1개를 via에서 dst로 이동
        }
    }
}
