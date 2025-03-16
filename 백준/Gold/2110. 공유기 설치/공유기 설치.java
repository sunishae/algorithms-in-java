import java.io.*;
import java.util.*;

public class Main {
    static int n,c;
    static int[] house;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        long min = 1;
        long max = house[n - 1] - house[0] + 1;

        while (min < max) {
            long mid = (min + max) / 2;

            if (install(mid)) {
                min = mid + 1;
            } else{
                max = mid;
            }
        }
        bw.write((min - 1) + "");
        br.close();
        bw.close();
    }

    public static boolean install(long distance) {
        int count = 1;
        int lastInstall = house[0];

        for (int i = 1; i < n; i++) {
            if (house[i] - lastInstall >= distance) {
                lastInstall = house[i];
                count++;
                if(count >= c) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
