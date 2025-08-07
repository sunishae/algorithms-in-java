import java.io.*;
import java.util.*;

public class Main {
    static String str;
    static Stack<Character> stack = new Stack<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bombLen) {
                boolean isBomb = true;
                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                if(isBomb){
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("FRULA");
        } else{
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
