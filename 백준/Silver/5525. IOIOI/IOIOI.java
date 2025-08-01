import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static String S;

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        int cnt = getCnt();

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    private static int getCnt() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (S.charAt(i) == 'I') {
                int oiCnt = 0;
                while (true) {
                    if (i + 2 >= M) break;
                    if (S.substring(i + 1, i + 3).compareTo("OI") == 0) {
                        oiCnt++;
                        i += 2;
                    } else break;
                }
                if (oiCnt >= N) {
                    cnt += (oiCnt - N + 1);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException{
        solution();
    }
}
