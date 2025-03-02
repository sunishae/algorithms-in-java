import java.io.*;
import java.util.*;

public class Main {
    static int n; // 노드의 개수
    static int m; // 간선의 개수
    static ArrayList<ArrayList<Node>> list = new ArrayList<>(); // 인접 리스트 (그래프)
    static int[] distance; // 최단 거리 배열
    static boolean[] visited; // 방문 여부 체크

    // 우선순위 큐에서 사용할 노드 클래스 (Comparable 인터페이스 구현)
    static class Node implements Comparable<Node> {
        int num; // 현재 노드 번호
        int fee; // 해당 노드까지의 거리 (비용)

        Node(int num, int fee) {
            this.num = num;
            this.fee = fee;
        }

        // 비용 기준으로 정렬 (우선순위 큐에서 사용)
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.fee, o.fee);
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 노드 개수 입력
        m = Integer.parseInt(st.nextToken()); // 간선 개수 입력

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>()); // 인접 리스트 초기화
        }
        distance = new int[n + 1]; // 최단 거리 배열
        Arrays.fill(distance, Integer.MAX_VALUE); // 최단 거리 배열을 무한대로 초기화
        visited = new boolean[n + 1]; // 방문 배열 초기화

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발 도시
            int v = Integer.parseInt(st.nextToken()); // 도착 도시
            int fee = Integer.parseInt(st.nextToken()); // 비용

            list.get(u).add(new Node(v, fee)); // 방향 그래프이므로 단방향 간선 추가
        }

        findShortcut(start);

    }

    // 다익스트라 알고리즘 (우선순위 큐 활용)
    public static void findShortcut(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 최소 힙을 위한 우선순위 큐 생성
        distance[start] = 0; // 시작 노드의 거리를 0으로 설정
        pq.offer(new Node(start, 0)); // 시작 노드를 우선순위 큐에 삽입

        while (!pq.isEmpty()) { // 큐가 빌 때까지 반복
            Node current = pq.poll(); // 현재 최소 거리 노드 선택
            int now = current.num; // 현재 노드 번호
            int nowDist = current.fee; // 현재까지의 최단 거리 비용

            // 이미 처리된 노드라면 무시
            if (distance[now] < nowDist) continue;

            // 현재 노드와 연결된 모든 인접 노드 탐색
            for (Node next : list.get(now)) {
                int cost = nowDist + next.fee; // 현재 노드를 거쳐서 가는 비용 계산
                if (cost < distance[next.num]) { // 기존 거리보다 더 짧다면 업데이트
                    distance[next.num] = cost;
                    pq.offer(new Node(next.num, cost)); // 우선순위 큐에 새로운 정보 삽입
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else
                System.out.println(distance[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
