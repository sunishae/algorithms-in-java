import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int G;
    static int P;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];

        init();

        int ans = 0;
        for (int i = 0; i < P; i++) {
            int plane = Integer.parseInt(br.readLine());

            int availableGate = find(plane);
            if (availableGate == 0) {
                break;
            }

            ans++;
            union(availableGate - 1, availableGate);
        }


        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    public static void init() {
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}