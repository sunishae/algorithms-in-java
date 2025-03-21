import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(Math.abs(a) > Math.abs(b))
                    return 1;
                else if(Math.abs(a) == Math.abs(b))
                    if(a > b) return 1;
                    else return -1;
                else return -1;
            }
        });

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
