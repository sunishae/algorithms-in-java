import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int max = 1;
    static int n;
    static char[][] board;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n; j++) {
                swap(i,j,i+1,j);
                search();
                swap(i+1,j,i,j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                swap(i,j,i,j+1);
                search();
                swap(i,j+1,i,j);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static void search(){
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for( int j = 0; j < n-1; j++){
                if(board[i][j] == board[i][j+1]){
                    cnt++;
                    max = Math.max(cnt, max);
                } else{
                    cnt = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for( int j = 0; j < n-1; j++){
                if(board[j][i] == board[j+1][i]){
                    cnt++;
                    max = Math.max(cnt, max);
                } else{
                    cnt = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
