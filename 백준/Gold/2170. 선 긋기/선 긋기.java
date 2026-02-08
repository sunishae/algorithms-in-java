import static java.util.Collections.sort;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Line> list = new ArrayList<>();

    public static class Line{
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Line(start, end));
        }

        list.sort((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        });

        int totalLength = getTotalLength();

        bw.write(totalLength + "");
        bw.flush();
        bw.close();
    }

    private static int getTotalLength() {
        Line curLine = list.get(0);
        int curStart = curLine.start;
        int curEnd = curLine.end;
        int totalLength = 0;

        for (int i = 1; i < N; i++) {
            Line next = list.get(i);

            if (next.start <= curEnd) {
                curEnd = Math.max(curEnd, next.end);
            }
            else {
                totalLength += (curEnd - curStart);
                curStart = next.start;
                curEnd = next.end;
            }
        }

        totalLength += (curEnd - curStart);
        return totalLength;
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}