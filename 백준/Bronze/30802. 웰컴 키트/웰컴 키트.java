import java.util.Scanner;

public class Main {

    public void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 참가자 수

        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }
        int t = sc.nextInt(); // 티셔츠 묶음
        int p = sc.nextInt(); // 펜 묶음

        int tSum = 0;
        for (int i = 0; i < 6; i++) {
            tSum += arr[i] / t;
            if (arr[i] % t != 0) tSum++;
        }

        System.out.println(tSum);
        System.out.println((n / p) + " " + (n % p));
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
