import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    static int cnt;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            GoodWord(word);
        }

        bw.write(cnt + "\n");
        bw.flush();
    }

    static void GoodWord(String word) {
        if (word.length() % 2 == 1) return;
        Stack<Character> stack = new Stack<>();
        stack.push(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (stack.size() > 0 && stack.peek() == word.charAt(i)) {
                stack.pop();
            } else {
                stack.push(word.charAt(i));
            }
        }
        if (stack.size() == 0) cnt++;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}