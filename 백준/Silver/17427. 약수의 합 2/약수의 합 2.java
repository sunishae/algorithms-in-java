import java.util.Scanner;

public class Main {
    final static int MOD = 9901;

    public void solution() throws Exception {
        int N;
        long res = 0; // 1000000까지 입력할 것을 고려

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            res += i * (N/i);
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
