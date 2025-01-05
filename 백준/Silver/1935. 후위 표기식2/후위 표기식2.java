import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        HashMap<Character, Double> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine()); // 피연산자 수
        String str = br.readLine(); // 후위 표기식 입력

        // A부터 차례대로 피연산자 값 입력받기
        for (int i = 0; i < n; i++) {
            double value = Double.parseDouble(br.readLine());
            map.put((char) ('A' + i), value); // 'A'부터 시작해서 차례대로 저장
        }

        // 후위 표기식 계산
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                stack.push(map.get(c)); // 피연산자 값 스택에 push
            } else {
                double v1 = stack.pop();
                double v2 = stack.pop();
                switch (c) {
                    case '*':
                        stack.push(v2 * v1);
                        break;
                    case '+':
                        stack.push(v2 + v1);
                        break;
                    case '-':
                        stack.push(v2 - v1);
                        break;
                    case '/':
                        stack.push(v2 / v1); // 실수 나눗셈
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop()); // 최종 결과 출력 (소수점 둘째 자리까지)
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
