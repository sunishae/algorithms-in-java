import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(n-- > 0){
            int x = Integer.parseInt(br.readLine());
            if( x== 0){
                if(pq.isEmpty()) {
                    bw.write("0\n");
                }
                else{
                    bw.write(pq.poll() + "\n");
                }
            } else{
                pq.offer(x);
            }
        }
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
