import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 상담 일 수
    static int max; // 최대 수익
    static int[][] schedule; // 스케줄 배열

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        max = 0;
        schedule = new int[N][2];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 상담 소요 기간
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 상담 금액
        }

        // DFS 탐색 시작
        dfs(0, 0);

        System.out.println(max); // 결과 출력
    }

    // DFS 메서드
    public static void dfs(int day, int sum) {
        // 날짜가 범위를 벗어나면 최대값 갱신 후 종료
        if (day >= N) {
            max = Math.max(max, sum);
            return;
        }

        // 현재 상담을 선택하는 경우
        if (day + schedule[day][0] <= N) { // 상담이 퇴사일 이전에 끝나는 경우만 선택
            dfs(day + schedule[day][0], sum + schedule[day][1]);
        }

        // 현재 상담을 선택하지 않는 경우
        dfs(day + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
