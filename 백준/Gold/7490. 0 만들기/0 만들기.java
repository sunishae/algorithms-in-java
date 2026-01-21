import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb; // 수식을 만드는 용도
    static StringBuilder resultSb; // 전체 정답을 모으는 용도

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        resultSb = new StringBuilder();

        while (t-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(1);
            resultSb.append("\n"); // 테스트 케이스 사이 빈 줄
        }
        System.out.print(resultSb.toString().trim()); // 마지막 불필요한 공백 제거 후 출력
    }

    public static void dfs(int depth) {
        sb.append(depth);

        if (depth == N) {
            if (calculate() == 0) {
                resultSb.append(sb.toString()).append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        char[] ops = {' ', '+', '-'}; // ASCII 순서: 공백(32), +(43), -(45)
        for (int i = 0; i < 3; i++) {
            sb.append(ops[i]);
            dfs(depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.deleteCharAt(sb.length() - 1);
    }

    public static int calculate() {
        // 공백을 제거하여 숫자를 이어붙임 (예: "1 2 + 3" -> "12+3")
        String expression = sb.toString().replace(" ", "");

        // 숫자와 연산자를 분리하여 계산
        String[] numbers = expression.split("[\\+\\-]");
        int result = Integer.parseInt(numbers[0]);

        int opIdx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+') {
                result += Integer.parseInt(numbers[++opIdx]);
            } else if (c == '-') {
                result -= Integer.parseInt(numbers[++opIdx]);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}