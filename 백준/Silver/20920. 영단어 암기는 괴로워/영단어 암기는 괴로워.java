import java.io.*;
import java.util.*;

public class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 단어 개수
        int m = Integer.parseInt(st.nextToken()); // 외울 최소 길이

        HashMap<String, Integer> map = new HashMap<>();

        // 단어 입력 및 빈도수 기록
        while (n-- > 0) {
            String s = br.readLine();
            if (s.length() < m) continue; // m 이상인 단어만 기록

            map.put(s, map.getOrDefault(s, 0) + 1); // 빈도 증가
        }

        // 리스트로 변환하여 정렬
        List<String> words = new ArrayList<>(map.keySet());

        words.sort((s1, s2) -> {
            // 1. 빈도수 내림차순 정렬
            if (!map.get(s1).equals(map.get(s2))) {
                return Integer.compare(map.get(s2), map.get(s1));
            }
            // 2. 길이 내림차순 정렬
            if (s1.length() != s2.length()) {
                return Integer.compare(s2.length(), s1.length());
            }
            // 3. 사전순 오름차순 정렬
            return s1.compareTo(s2);
        });

        // 결과 출력
        for (String word : words) {
            bw.write(word + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
