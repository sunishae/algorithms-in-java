import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import static java.util.Arrays.sort;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;
        for(int i =0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int a = 0, b = 0;

        for (int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++){
                if(100 == sum - (arr[i] + arr[j])){
                    a = arr[i];
                    b = arr[j];
                }
            }
        }
        Arrays.sort(arr);

        for (int i = 0; i < 9; i++) {
            if(arr[i] == a || arr[i] == b) continue;
            bw.write(String.valueOf(arr[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
