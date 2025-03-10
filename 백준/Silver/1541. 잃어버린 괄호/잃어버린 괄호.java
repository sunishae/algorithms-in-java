import java.io.*;
import java.util.*;

public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = Integer.MAX_VALUE;
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");

        while (sub.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer plus = new StringTokenizer(sub.nextToken(), "+");
            while(plus.hasMoreTokens()){
                temp += Integer.parseInt(plus.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else{
                sum -= temp;
            }
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}