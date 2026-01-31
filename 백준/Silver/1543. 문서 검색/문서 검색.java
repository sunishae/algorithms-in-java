import java.io.*;
import java.util.*;

public class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String text = br.readLine();
        String s = br.readLine();

        int ans = 0;
        int idx = 0;
        while ((idx = text.indexOf(s, idx)) != -1) {
            idx += s.length();
            ans++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}