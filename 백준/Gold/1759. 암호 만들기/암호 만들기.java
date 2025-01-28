import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static char[] arr;
    static char[] vowels = {'a','e','i','o','u'};
    static char[] result;
    static StringBuilder sb = new StringBuilder();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        arr = new char[C];
        result = new char[L];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st2.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == L) {
            int vowelCount = 0;
            for (char c : result) {
                if (isVowel(c)) vowelCount++;
            }
            if (vowelCount >= 1 && (L - vowelCount) >= 2) {
                for (char val : result) {
                    sb.append(val);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1); // visit[] 제거
        }
    }

    public static boolean isVowel(char c) {
        for (char check : vowels) {
            if (check == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}