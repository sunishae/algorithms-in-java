import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine(); // 중위 표기식 입력
        stack.push('@'); // '@'는 시작을 표시하는 특수 문자

        for (String str1 : str.split("")) {
            char val = str1.charAt(0);
            char prev = stack.peek();

            switch (val) {
                case '+':
                case '-':
                    while (precedence(prev) >= precedence(val)) {
                        System.out.print(stack.pop());
                        prev = stack.peek();
                    }
                    stack.push(val);
                    break;
                case '*':
                case '/':
                    while (precedence(prev) >= precedence(val)) {
                        System.out.print(stack.pop());
                        prev = stack.peek();
                    }
                    stack.push(val);
                    break;
                case '(':
                    stack.push(val);
                    break;
                case ')':
                    while (stack.peek() != '(') {
                        System.out.print(stack.pop());
                    }
                    stack.pop(); // '(' 제거
                    break;
                default:
                    System.out.print(val); // 피연산자 출력
                    break;
            }
        }

        // 스택에 남아 있는 연산자 모두 출력
        while (stack.peek() != '@') {
            System.out.print(stack.pop());
        }
    }

    private int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0; // '('와 '@'는 우선순위가 0
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
