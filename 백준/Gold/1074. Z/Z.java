import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int r;
    static int c;
    static int cnt = 0;
    static int result = 0;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, n);

        recur(len, 0, 0);

        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void recur(int m, int x, int y) {
        if(m == 1){
            result = cnt;
            return;
        }
        int mid = m / 2;
        if (r < x + mid && c < y + mid) {             // 0번: 왼쪽 위
            recur(mid, x, y);
        } else if (r < x + mid && c >= y + mid) {      // 1번: 오른쪽 위
            cnt += mid * mid;
            recur(mid, x, y + mid);
        } else if (r >= x + mid && c < y + mid) {      // 2번: 왼쪽 아래
            cnt += 2 * mid * mid;
            recur(mid, x + mid, y);
        } else {                                       // 3번: 오른쪽 아래
            cnt += 3 * mid * mid;
            recur(mid, x + mid, y + mid);
        }

    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}