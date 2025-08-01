import java.io.*;
import java.util.*;

public class Main {
    static String func;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            boolean isReversed = false;
            func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);  // 괄호 제거

            ArrayDeque<Integer> dq = new ArrayDeque<>();
            if (!str.isEmpty()) {
                String[] nums = str.split(",");
                for (int i = 0; i < n; i++) {
                    dq.add(Integer.parseInt(nums[i]));
                }
            }

            boolean isError = false;
            for (int i = 0; i < func.length(); i++) {
                char f = func.charAt(i);
                if (f == 'R') {
                    isReversed = !isReversed;
                } else if (f == 'D') {
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        dq.removeLast();
                    } else {
                        dq.removeFirst();
                    }
                }
            }

            if (isError) {
                bw.write("error\n");
            } else {
                bw.write("[");
                while (!dq.isEmpty()) {
                    bw.write(String.valueOf(isReversed ? dq.removeLast() : dq.removeFirst()));
                    if (!dq.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
