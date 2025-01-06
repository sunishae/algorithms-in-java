import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.util.Arrays.sort;

public class Main {

    public static boolean[] prime;	// 소수를 체크할 배열

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        make_prime(1000000);

        int t = 0;
        while ((t = Integer.parseInt(br.readLine())) != 0) {
            boolean flag = false;
            for(int i =0; i<= t/2; i++){
                if(!prime[i] && !prime[t - i]){
                    System.out.println(t + " = " + i + " + " + (t-i));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }

    public static void make_prime(int N) {
        prime = new boolean[N + 1];

        prime[0] = prime[1] = true;

        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(N); i++) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if(prime[i] == true) {
                continue;
            }

            // i 의 배수들을 걸러주기 위한 반복문
            for(int j = i * i; j < prime.length; j = j+i) {
                prime[j] = true;
            }
        }


    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
