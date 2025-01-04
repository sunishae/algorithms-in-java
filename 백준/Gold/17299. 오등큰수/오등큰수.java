import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine()); // 숫자 개수
        int[] arr = new int[n]; // 숫자들
        int[] ngf = new int[n]; // 오등큰수
        Stack<Integer> stack = new Stack<>();

        // 입력받은 숫자들을 배열에 저장하고 등장 횟수 카운팅
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 스택을 이용하여 오등큰수 찾기
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && map.get(arr[i]) >= map.get(stack.peek())) {
                stack.pop(); // 등장 횟수가 더 작거나 같은 수는 제거
            }

            if (stack.isEmpty()) {
                ngf[i] = -1; // 오등큰수가 없는 경우
            } else {
                ngf[i] = stack.peek(); // 오등큰수 설정
            }

            stack.push(arr[i]); // 현재 숫자를 스택에 추가
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ngf[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
