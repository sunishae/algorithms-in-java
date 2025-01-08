import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        BigInteger n = new BigInteger(s, 8);
        String result = n.toString(2);

        bw.write(result);
        bw.flush();

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
