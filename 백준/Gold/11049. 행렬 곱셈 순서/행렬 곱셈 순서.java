import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int mink;
    static int[] d;
    static int[][] M;
    static int[][] P;
    final static int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        d = new int[n + 1];
        M = new int[n+1][n+1];
        P = new int[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        d[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            d[i+1] = Integer.parseInt(st.nextToken());
        }

        minmult();

        bw.write(M[1][n] + "");
        bw.flush();
        bw.close();
    }

    public static void minmult(){
        for (int i = 1; i <= n; i++) {
            M[i][i] = 0;
        }
        for (int diagonal = 1; diagonal <= n - 1; diagonal++) {
            for (int i = 1; i <= n - diagonal; i++) {
                int j = i + diagonal;
                M[i][j] = minimum(i, j);
                P[i][j] = mink;
            }
        }
    }

    public static int minimum(int i, int j){
        int minValue = INF;
        int value;
        for (int k = i; k <= j - 1; k++) {
            value = M[i][k] + M[k+1][j] +d[i-1] * d[k] * d[j];
            if(minValue > value){
                minValue = value;
                mink = k;
            }
        }
        return minValue;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
