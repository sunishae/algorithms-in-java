import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;
    static StringBuilder sb;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            M = Integer.parseInt(br.readLine());
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            sb = new StringBuilder();

            sb.append(M/2+1 + "\n");
            int cnt = 0;

            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());

                if (minHeap.size() == maxHeap.size()) {
                    maxHeap.offer(x);
                } else {
                    minHeap.offer(x);
                }

                if (!minHeap.isEmpty()) {
                    if (minHeap.peek() < maxHeap.peek()) {
                        int toMin = maxHeap.poll();
                        int toMax = minHeap.poll();
                        minHeap.offer(toMin);
                        maxHeap.offer(toMax);
                    }
                }

                if (i % 2 == 0) {

                    if (cnt == 9 || i == M - 1) {
                        sb.append(maxHeap.peek() + "\n");
                        cnt = 0;
                    } else {
                        sb.append(maxHeap.peek() + " ");
                    }
                    cnt++;
                }
            }
            bw.write(sb.toString());
        }


        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}