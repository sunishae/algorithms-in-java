import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static int firstCnt = 0;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        fib(n);

        bw.write(firstCnt + " " + (n - 2));
        bw.close();
    }

    public static int fib(int n) {
        if (n == 1 || n == 2){
            firstCnt++;
            return 1;
        }
        else return (fib(n - 1) + fib(n - 2));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
