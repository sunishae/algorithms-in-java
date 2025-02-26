import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int[][] wheel;
    static int k;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        wheel = new int[t][8];

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = s.charAt(j) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) { // k번 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1; // 0-based index 변환
            int direction = Integer.parseInt(st.nextToken());
            rotation(number, direction);
        }

        bw.write(checkTwelve() + "\n");
        bw.flush();
        bw.close();
    }

    public static void rotation(int start, int direction) {
        int[] rotateDir = new int[t];
        rotateDir[start] = direction;

        // 왼쪽으로 전달
        for (int i = start - 1; i >= 0; i--) {
            if (wheel[i][2] != wheel[i + 1][6]) {
                rotateDir[i] = -rotateDir[i + 1];
            } else break;
        }

        // 오른쪽으로 전달
        for (int i = start + 1; i < t; i++) {
            if (wheel[i][6] != wheel[i - 1][2]) {
                rotateDir[i] = -rotateDir[i - 1];
            } else break;
        }

        // 회전 적용
        for (int i = 0; i < t; i++) {
            if (rotateDir[i] == 1) rotationRight(i);
            else if (rotateDir[i] == -1) rotationLeft(i);
        }
    }

    public static void rotationRight(int number) {
        int temp = wheel[number][7];
        for (int i = 7; i > 0; i--) {
            wheel[number][i] = wheel[number][i-1];
        }
        wheel[number][0] = temp;
    }

    public static void rotationLeft(int number) {
        int temp = wheel[number][0];
        for (int i = 0; i < 7; i++) {
            wheel[number][i] = wheel[number][i+1];
        }
        wheel[number][7] = temp;
    }

    public static int checkTwelve() {
        int cnt = 0;
        for (int i = 0; i < t; i++) {
            if (wheel[i][0] == 1) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
