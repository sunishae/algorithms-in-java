import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int answer;
    static int[] fruits;
    static HashMap<Integer, Integer> cnt = new HashMap<>();

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        int left = 0;
        for(int right = 0; right < N; right++) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);

            while(cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);

                if(cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }

                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException{
        solution();
    }
}
