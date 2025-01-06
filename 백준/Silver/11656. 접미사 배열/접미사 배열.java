import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.util.Arrays.sort;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = new String[s.length()];
        for( int i = 0; i < s.length(); i++ ) {
            arr[i] = new String(s.substring(i, s.length()));
        }
        sort(arr);
        for( int i = 0; i < arr.length; i++ ) {
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
