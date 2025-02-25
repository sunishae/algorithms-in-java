import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int l;
    static int[][] map;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if(check_width(i)) result++;
            if(check_length(i)) result++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    public static boolean check_width(int index) {
        boolean[] isIncline = new boolean[n]; //경사면 설치 여부를 확인하는 배열

        for(int i = 0; i < n - 1; i++) {
            int diff = map[index][i] - map[index][i + 1];

            if(diff > 1 || diff < -1) return false; //높이차 1 초과하므로 false
            else if(diff == -1) { // 다음 계단이 한 계단 높다
                for(int j = 0; j < l; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    if(i - j < 0 || isIncline[i - j]) return false;
                    if(map[index][i] != map[index][i - j]) return false;
                    isIncline[i - j]  = true; //경사면 설치
                }
            }
            else if(diff == 1) { //다음 계단이 한 계단 낮다
                for(int j = 1; j <= l; j++) { //내려가는 경사로를 설치할 수 있는지 확인한다.
                    if(i + j >= n || isIncline[i + j]) return false;
                    if(map[index][i] - 1 != map[index][i + j]) return false;
                    isIncline[i + j] = true; //경사면 설치
                }
            }
        }
        return true;
    }

    public static boolean check_length(int index) {
        boolean[] isIncline = new boolean[n]; //경사면 설치 여부를 확인하는 배열

        for(int i = 0; i < n - 1; i++) {
            int diff = map[i][index] - map[i+1][index];

            if(diff > 1 || diff < -1) return false;
            else if(diff == -1) {
                for(int j = 0; j < l; j++) {
                    if(i - j < 0 || isIncline[i - j]) return false;
                    if(map[i][index] != map[i - j][index]) return false;
                    isIncline[i - j]  = true;
                }
            }
            else if(diff == 1) {
                for(int j = 1; j <= l; j++) {
                    if(i + j >= n || isIncline[i + j]) return false;
                    if(map[i][index] - 1 != map[i + j][index]) return false;
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
