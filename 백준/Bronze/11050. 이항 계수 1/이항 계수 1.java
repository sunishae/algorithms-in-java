import java.util.Scanner;

public class Main {

    public void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 자연수 N
        int k = sc.nextInt(); // 정수 K
        int c = factorial(n) / (factorial(k) * factorial(n - k));

        System.out.println(c);
    }

    static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
