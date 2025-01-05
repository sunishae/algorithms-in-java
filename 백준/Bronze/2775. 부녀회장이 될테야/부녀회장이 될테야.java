import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            for(int j = 0; j < k; j++){
                for(int l = 1; l < n; l++){
                    arr[l] = arr[l-1] + arr[l];
                }
            }

            System.out.println(arr[n-1]);
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
