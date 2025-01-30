import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static char[] arr;
    static boolean[] visit;
    static int[] result;
    static String max = ""; // 최대값을 문자열로 저장
    static String min = ""; // 최소값을 문자열로 저장

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        visit = new boolean[10]; // 숫자 0~9 사용 여부를 체크
        result = new int[k + 1];
        arr = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        dfs(0);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth) {
        if (depth == k + 1) { // 숫자 조합이 완성된 경우
            if (check()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < k + 1; i++) {
                    sb.append(result[i]);
                }
                String current = sb.toString(); // 현재 숫자 조합을 문자열로 변환

                // 문자열 비교를 통해 최대값과 최소값 갱신
                if (max.isEmpty() || current.compareTo(max) > 0) {
                    max = current;
                }
                if (min.isEmpty() || current.compareTo(min) < 0) {
                    min = current;
                }
            }
            return; // 깊이 탐색 종료
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) { // 방문하지 않은 숫자만 선택
                visit[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visit[i] = false; // 백트래킹
            }
        }
    }

    public static boolean check() {
        for (int i = 0; i < k; i++) {
            if (arr[i] == '<' && result[i] >= result[i + 1]) {
                return false;
            }
            if (arr[i] == '>' && result[i] <= result[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
