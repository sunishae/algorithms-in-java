import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String st = "";

        while((st = br.readLine()) != null && !st.isEmpty()){
            sb = new StringBuilder();
            int n = Integer.parseInt(st);
            func(n);
            bw.write(sb + "\n");
        }
        bw.close();
    }

    public static void func(int n) {
        if(n == 0){
            sb.append('-');
            return;
        }
        func(n - 1);
        for (int i = 0; i < Math.pow(3, n - 1); i++) {
            sb.append(' ');
        }
        func(n - 1);

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
