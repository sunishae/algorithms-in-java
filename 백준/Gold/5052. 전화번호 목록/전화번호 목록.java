import java.io.*;
import java.util.*;

public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] list = new String[n];

            for (int i = 0; i < n; i++) {
                list[i] = br.readLine();
            }

            Arrays.sort(list);

            boolean flag = false;
            for (int i = 0; i < n - 1; i++) {
                if (list[i+1].startsWith(list[i])) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}