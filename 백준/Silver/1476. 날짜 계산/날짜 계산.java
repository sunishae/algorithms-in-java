import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1;
        int year = 1;
        while (E != e || S != s || M != m) {
            year++;
            e = (year % 15 == 0) ? 15 : year % 15;
            s = (year % 28 == 0) ? 28 : year % 28;
            m = (year % 19 == 0) ? 19 : year % 19;
        }

        bw.write(String.valueOf(year));
        bw.flush();
        bw.close();
    }



    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
