import java.io.*;
import java.util.*;

public class Main {
    static int pay;
    static final int[] coins = {500, 100, 50, 10, 5, 1};
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        pay = Integer.parseInt(br.readLine());
        int change = 1000 - pay;

        int cnt = 0;
        for (int i = 0; i < coins.length; i++) {
            cnt += change / coins[i];
            change %= coins[i];
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}