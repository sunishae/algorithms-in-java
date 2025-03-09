import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet enterMember = new HashSet();

        int N = Integer.parseInt(br.readLine()); 
        int count = 0; 

        while(N --> 0) { 
            String str = br.readLine();

            if(str.equals("ENTER")) { 
                count += enterMember.size(); 
                enterMember.clear(); 
                continue; 
            }

            enterMember.add(str);
        }

        count += enterMember.size();

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}