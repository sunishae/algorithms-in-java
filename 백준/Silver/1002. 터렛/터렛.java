import java.io.*;
import java.util.*;

public class Main {
    static int x1, y1;
    static int x2, y2;
    static int r1, r2;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            int answer;
            int distSq = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                answer = -1; // 무한대
            } else if (distSq > Math.pow(r1 + r2, 2) || distSq < Math.pow(r1 - r2, 2)) {
                answer = 0; // 안 만남
            } else if (distSq == Math.pow(r1 + r2, 2) || distSq == Math.pow(r1 - r2, 2)) {
                answer = 1; // 접함
            } else {
                answer = 2; // 두 점
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}