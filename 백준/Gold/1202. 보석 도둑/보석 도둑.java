import java.io.*;
import java.util.*;

public class Main {
    static int N; // 보석 개수
    static int K; // 가방 개수
    static int[] bag;

    public static class Jewelry {
        int weight; // 무게
        int value; // 가치

        Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(m, v);
        }

        Arrays.sort(jewelries, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.value - o1.value;
            } else {
                return o1.weight - o2.weight;
            }
        });

        bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewelries[j].weight <= bag[i]) {
                pq.offer(jewelries[j++].value);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }


        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}