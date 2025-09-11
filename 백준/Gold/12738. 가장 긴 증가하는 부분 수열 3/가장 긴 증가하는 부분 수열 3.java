import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        list.add(A[0]);
        for (int i = 1; i < N; i++) {
            if(list.get(list.size() - 1) < A[i]) list.add(A[i]);
            else {
                int lo = 0;
                int hi = list.size() - 1;

                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if(list.get(mid) < A[i]){
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                list.set(lo, A[i]);
            }
        }
        bw.write(list.size() + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void recur(int n) {

    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}
