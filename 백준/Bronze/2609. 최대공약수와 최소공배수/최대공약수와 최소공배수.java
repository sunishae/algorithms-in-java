import java.util.Scanner;

public class Main {

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a,b));
        System.out.println(a * b / gcd(a,b));
    }
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        new Main().solution();
    }
}
