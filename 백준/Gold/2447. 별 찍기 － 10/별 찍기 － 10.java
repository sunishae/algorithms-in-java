import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 3의 거듭제곱
        arr = new char[n][n];

        func(0,0,n,false);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void func(int r, int c, int n, boolean zero) {

        if(zero){
            for (int i = r; i < r + n; i++) {
                for (int j = c; j < c + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1){
            arr[r][c] = '*';
            return;
        }

        int size = n / 3;
        int cnt = 0;
        for (int i = r; i < r + n; i += size) {
            for (int j = c; j < c + n; j += size) {
                cnt++;
                if(cnt == 5)
                    func(i, j, size, true);
                else
                    func(i, j, size, false);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
