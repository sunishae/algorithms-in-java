import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long count5 = check_factor(n,5) - check_factor(n-m,5) - check_factor(m,5);
        long count2 = check_factor(n,2) - check_factor(n-m,2) - check_factor(m,2);
        System.out.println(Math.min(count5, count2));

    }

    static long check_factor(long num, int t){
        int cnt = 0;

        while(num >=t){
            cnt += (num / t);
            num /= t;
        }
        return cnt;
    }





    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
