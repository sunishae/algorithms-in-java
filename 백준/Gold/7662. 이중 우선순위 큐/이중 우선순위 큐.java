import java.io.*;
import java.util.*;

public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int T = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if(map.isEmpty()) continue;
                    int del;
                    if (num == 1) {
                        del = map.lastKey();
                    } else {
                        del = map.firstKey();
                    }
                    if (map.put(del, map.get(del) - 1) == 1) {
                        map.remove(del);
                    }
                }
            }
            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
