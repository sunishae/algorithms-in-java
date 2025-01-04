import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int resultInt = A + B - C;

        bw.write(resultInt+"\n");
        bw.flush();

        String As = A + "";
        String Bs = B + "";

        bw.write(Integer.parseInt(As + Bs)  - C + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}