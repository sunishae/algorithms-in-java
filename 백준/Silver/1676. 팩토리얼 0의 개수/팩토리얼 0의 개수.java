import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.util.Arrays.sort;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt=0;

        BigInteger big = new BigInteger("1");
        for(int i=1; i<=n; i++){
            big = big.multiply(BigInteger.valueOf(i));
        }
        String s = big.toString();
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)-'0'==0) cnt++;
            else break;
        }
        System.out.println(cnt);
    }
    

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
