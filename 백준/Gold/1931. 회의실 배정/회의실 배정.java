import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Meet> list = new ArrayList<>();

    public static class Meet implements Comparable<Meet>{
        int start;
        int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet meet) {
            if(this.end != meet.end){
                return Integer.compare(this.end, meet.end);
            }
            return Integer.compare(this.start, meet.start);
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meet(start, end));
        }

        Collections.sort(list);
        int idx = list.get(0).end;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            int tmp = list.get(i).start;
            if(tmp >= idx){
                cnt++;
                idx = list.get(i).end;
            }
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }



    public static void main(String[] args) throws Exception {
        solution();
    }
}