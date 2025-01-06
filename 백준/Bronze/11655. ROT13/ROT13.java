import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 암호
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                int t = c - 'A';
                t = (t + 13)% 26 + 'A';
                System.out.print((char)t);
            }
            else if (Character.isLowerCase(c)) {
                int t = c - 'a';
                t = (t + 13)% 26 + 'a';
                System.out.print((char)t);
            }
            else{
                System.out.print(c);
            }
        }
        System.out.println();

    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
