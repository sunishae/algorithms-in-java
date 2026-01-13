import static java.lang.System.exit;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int change = Integer.parseInt(br.readLine());

        if (change == 1 || change == 3) {
            bw.write("-1");
        } else {
            n = change / 5;
            change = change % 5;

            if (change == 1) {
                n += 2;
            } else if (change == 2) {
                n += 1;
            } else if (change == 3) {
                n += 3;
            } else if (change == 4) {
                n += 2;
            }

            bw.write(n + "");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
