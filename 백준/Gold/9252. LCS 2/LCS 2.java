import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int lenA = a.length;
        int lenB = b.length;

        int[][] dp = new int[lenA + 1][lenB + 1];

        for (int i = 1; i <= lenA; i++) {
            for(int j = 1; j <= lenB; j++) {
                if(a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        while(lenA > 0 && lenB > 0){
            if(dp[lenA][lenB] == dp[lenA-1][lenB])
                lenA--;
            else if (dp[lenA][lenB] == dp[lenA][lenB-1])
                lenB--;
            else{
                stack.push(a[lenA-1]);
                lenA--;
                lenB--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(dp[a.length][b.length] + "\n" + sb.toString());
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
