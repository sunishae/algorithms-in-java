import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int current = 100;
    static boolean[] number = new boolean[10];

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 목표 채널
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼 개수

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                number[tmp] = true; // 고장난 버튼 기록
            }
        }

        int shortcut = Math.abs(n - current); // + 또는 -만 눌렀을 때 이동 횟수

        // 0부터 999,999까지 가능한 모든 채널 탐색
        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean isBreak = false;

            // 해당 숫자를 만들 수 있는지 확인
            for (int j = 0; j < num.length(); j++) {
                if (number[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            // 숫자를 만들 수 있다면 이동 횟수 계산
            if (!isBreak) {
                int min = Math.abs(n - i) + num.length(); // 이동 횟수 계산
                shortcut = Math.min(min, shortcut); // 최소 이동 횟수 갱신
            }
        }

        bw.write(String.valueOf(shortcut)); // 결과 출력
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
