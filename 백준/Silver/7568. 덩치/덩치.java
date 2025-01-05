import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 사람 수
        int[][] man = new int[n][2];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            man[i][0] = Integer.parseInt(st.nextToken());
            man[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<n; i++){
            int output = 1;
            for(int j = 0; j<n; j++){
                if(man[i][0] < man[j][0] && man[i][1] < man[j][1]){
                    output++;
                }
            }
            System.out.println(output);
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
