import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }


        do{
            for (int i = 0; i < n; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }while(check());

        bw.flush();
        bw.close();
    }

    static boolean check(){
        int idx = n-1;
        while(idx > 0 && arr[idx-1] > arr[idx]){
            idx--;
        }
        if(idx == 0) return false;

        int j = n-1;
        while(arr[idx-1] > arr[j]){
            j--;
        }

        swap(idx - 1, j);

        j = n-1;
        while(idx < j){
            swap(idx, j);
            idx++;
            j--;
        }
        return true;

    }

    static void swap(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
