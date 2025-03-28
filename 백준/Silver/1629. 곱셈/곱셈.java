import java.io.*;
import java.util.*;

public class Main {
    static int a,b;
    static int c;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bw.write((recur(a, b) % c)  + "");
        br.close();
        bw.close();
    }

    public static long recur(int n, int m) {
        if(m == 1) return n % c;

        long tmp = recur(n, m / 2);

        if(m % 2 == 1) {
            return (tmp * tmp % c) * n % c;
        }
        else return tmp * tmp % c;
    }



    public static void main(String[] args) throws Exception {
        solution();
    }
}