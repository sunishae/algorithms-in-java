import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] arr;
    static int[][] tempArr;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int select = Integer.parseInt(st.nextToken());

            switch (select) {
                case 1: func1(); break;
                case 2: func2(); break;
                case 3: func3(); break;
                case 4: func4(); break;
                case 5: func5(); break;
                case 6: func6(); break;
            }
        }

        printArr(bw);
    }

    public static void func1() { // 상하 반전
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                change(i, j, n - i - 1, j);
            }
        }
    }

    public static void func2() { // 좌우 반전
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                change(i, j, i, m - j - 1);
            }
        }
    }

    public static void func3() { // 오른쪽 90도 회전
        tempArr = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempArr[j][n - i - 1] = arr[i][j];
            }
        }
        swapArr();
    }

    public static void func4() { // 왼쪽 90도 회전
        tempArr = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempArr[m - j - 1][i] = arr[i][j];
            }
        }
        swapArr();
    }

    public static void func5() { // 4개 그룹 시계방향 이동
        tempArr = new int[n][m];
        int halfN = n / 2, halfM = m / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < halfN && j < halfM) // 1 -> 2
                    tempArr[i][j + halfM] = arr[i][j];
                else if (i < halfN && j >= halfM) // 2 -> 3
                    tempArr[i + halfN][j] = arr[i][j];
                else if (i >= halfN && j >= halfM) // 3 -> 4
                    tempArr[i][j - halfM] = arr[i][j];
                else // 4 -> 1
                    tempArr[i - halfN][j] = arr[i][j];
            }
        }
        copyTempToArr();
    }

    public static void func6() { // 4개 그룹 반시계방향 이동
        tempArr = new int[n][m];
        int halfN = n / 2, halfM = m / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < halfN && j < halfM) // 1 -> 4
                    tempArr[i + halfN][j] = arr[i][j];
                else if (i < halfN && j >= halfM) // 2 -> 1
                    tempArr[i][j - halfM] = arr[i][j];
                else if (i >= halfN && j >= halfM) // 3 -> 2
                    tempArr[i - halfN][j] = arr[i][j];
                else // 4 -> 3
                    tempArr[i][j + halfM] = arr[i][j];
            }
        }
        copyTempToArr();
    }

    public static void change(int x1, int y1, int x2, int y2) { // 자리 변경
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    public static void swapArr() { // 배열 크기 교환 및 복사
        int temp = n;
        n = m;
        m = temp;
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.copyOf(tempArr[i], m);
        }
    }

    public static void copyTempToArr() { // 같은 크기의 배열 복사
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.copyOf(tempArr[i], m);
        }
    }

    public static void printArr(BufferedWriter bw) throws IOException { // 출력 최적화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
