import java.io.*;
import java.util.*;

public class Main {
    static int N;

    // 강의를 시작 시간을 기준으로 오름차순 정렬하기 위한 클래스
    public static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        // 1. 모든 강의를 시작 시간 오름차순으로 정렬 (PriorityQueue를 사용하거나, ArrayList + Collections.sort 사용)
        PriorityQueue<Lecture> sortedLectures = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sortedLectures.add(new Lecture(s, e));
        }

        // 2. 강의실의 종료 시간을 관리하는 우선순위 큐 (가장 빨리 끝나는 강의실이 맨 위에 오도록)
        PriorityQueue<Integer> roomEnds = new PriorityQueue<>();

        // 3. 정렬된 강의를 하나씩 처리
        while (!sortedLectures.isEmpty()) {
            Lecture currentLecture = sortedLectures.poll();

            // 현재 강의실에 배정할 강의실이 없으면 새로 추가
            if (roomEnds.isEmpty()) {
                roomEnds.add(currentLecture.end);
            } else {
                // 가장 빨리 끝나는 강의실의 종료 시간을 확인
                int earliestEndTime = roomEnds.peek();

                // 현재 강의의 시작 시간이 가장 빨리 끝나는 강의실의 종료 시간보다 크거나 같으면,
                // 해당 강의실을 재사용
                if (currentLecture.start >= earliestEndTime) {
                    roomEnds.poll(); // 가장 빨리 끝나는 강의실을 빼고
                    roomEnds.add(currentLecture.end); // 현재 강의로 갱신
                } else {
                    // 그렇지 않으면 새로운 강의실을 추가
                    roomEnds.add(currentLecture.end);
                }
            }
        }

        bw.write(roomEnds.size() + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
