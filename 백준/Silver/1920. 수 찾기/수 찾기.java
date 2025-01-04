import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public void solution() {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            map.put(tmp,tmp);
        }

        int m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            int search = sc.nextInt();
            if (map.containsKey(search))
                System.out.println(1);
            else
                System.out.println(0);
        }

    }
    public static void main(String[] args) {
        new Main().solution();
    }
}
