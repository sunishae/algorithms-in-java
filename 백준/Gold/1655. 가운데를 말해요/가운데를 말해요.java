import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(x);
            } else {
                minHeap.offer(x);
            }

            if (!minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int t1 = maxHeap.poll();
                    int t2 = minHeap.poll();

                    maxHeap.offer(t2);
                    minHeap.offer(t1);
                }
            }

            bw.write(maxHeap.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}