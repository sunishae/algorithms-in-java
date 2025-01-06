import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        long first = Long.parseLong(a + b);
        String c = st.nextToken();
        String d = st.nextToken();
        long second = Long.parseLong(c + d);

        System.out.println(first + second);
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
