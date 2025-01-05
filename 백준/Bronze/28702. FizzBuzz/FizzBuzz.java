import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        for(int i = 0; i < 3; i++){
            arr[i] = br.readLine();
        }

        int result = 0;
        for(int i = 0; i < 3; i++){
            if(arr[i].equals("FizzBuzz") || arr[i].equals("Fizz") || arr[i].equals("Buzz")) continue;
            else{
                result = Integer.parseInt(arr[i]) + (3 - i);
                break;
            }
        }

        if(result % 3 == 0 && result % 5 == 0) System.out.println("FizzBuzz");
        else if(result % 3 == 0) System.out.println("Fizz");
        else if(result % 5 == 0) System.out.println("Buzz");
        else System.out.println(result);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
