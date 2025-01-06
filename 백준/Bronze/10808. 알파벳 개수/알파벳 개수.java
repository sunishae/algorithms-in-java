import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 소문자로만 이루어진 단어 s
        int[] test = new int[26];

        for( int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            test[c - 'a']++;
        }
        for( int i = 0; i < 26; i++ ) {
            System.out.print(test[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
