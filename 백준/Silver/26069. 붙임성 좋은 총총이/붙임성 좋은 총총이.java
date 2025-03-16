import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static HashSet<String> hashSet = new HashSet<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        hashSet.add("ChongChong");

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if (hashSet.contains(s1) || hashSet.contains(s2)) {
                hashSet.add(s1);
                hashSet.add(s2);
            }

        }
        int result = hashSet.size();

        bw.write(result + "");
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
