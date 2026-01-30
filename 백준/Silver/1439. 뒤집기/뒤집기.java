import java.io.*;
import java.util.*;

public class Main {
    static String s;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine();

        char cur = s.charAt(0);
        int cnt = 1;
        for (int i = 0; i < s.length(); i++) {
            if (cur != s.charAt(i)) {
                cnt++;
                cur = s.charAt(i);
            }
        }

        bw.write(cnt / 2+ "");
        bw.flush();
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
