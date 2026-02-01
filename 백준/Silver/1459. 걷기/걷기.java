import java.io.*;
import java.util.*;

public class Main {
    static long X, Y; // 집 위치
    static long W; // 가로세로 시간
    static long S; // 대각선 시간

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken());
        S = Long.parseLong(st.nextToken());

        long temp1 = (X + Y) * W;
        long temp2 = 0;
        if ((X + Y) % 2 == 0) {
            temp2 = Math.max(X, Y) * S;
        } else {
            temp2 = (Math.max(X, Y) - 1) * S + W;
        }

        long temp3 = (Math.min(X, Y)) * S + (Math.abs(X - Y)) * W;

        bw.write(Math.min(temp1, Math.min(temp2, temp3)) + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}