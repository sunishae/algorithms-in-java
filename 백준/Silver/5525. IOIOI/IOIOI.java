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

        String comp = "IO";
        for (int i = 0; i < N - 1; i++) {
            comp = comp + "IO";
        }
        comp = comp + "I";

        int cnt = 0;
        int idx = 0;
        while(idx < M){
            idx = S.indexOf(comp, idx);
            if(idx == -1) break;
            cnt++;
            idx++;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException{
        solution();
    }
}
