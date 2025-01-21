import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int max = 0;
    static int n;
    static int m;

    // 테트로미노의 19가지 모양을 정의
    static int[][][] tetrominos = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // 일자형 가로
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // 일자형 세로
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // 네모형
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // ㄱ자형 1
            {{0, 1}, {1, 1}, {2, 1}, {2, 0}}, // ㄱ자형 2
            {{0, 0}, {1, 0}, {2, 0}, {0, 1}}, // ㄱ자형 3
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, // ㄱ자형 4
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}}, // ㄱ자형 5
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // ㄱ자형 6
            {{1, 0}, {1, 1}, {1, 2}, {0, 2}}, // ㄱ자형 7
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, // ㄱ자형 8
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // Z자형 1
            {{0, 1}, {1, 0}, {1, 1}, {2, 0}}, // Z자형 2
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // Z자형 3
            {{1, 0}, {1, 1}, {0, 1}, {0, 2}}, // Z자형 4
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // ㅗ자형 1
            {{0, 1}, {1, 0}, {1, 1}, {2, 1}}, // ㅗ자형 2
            {{1, 0}, {1, 1}, {1, 2}, {0, 1}}, // ㅗ자형 3
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}}  // ㅗ자형 4
    };

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculateMax();

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static void calculateMax() {
        for (int[][] tetromino : tetrominos) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int sum = 0;
                    boolean valid = true;
                    for (int[] block : tetromino) {
                        int x = i + block[0];
                        int y = j + block[1];
                        if (x < 0 || x >= n || y < 0 || y >= m) {
                            valid = false;
                            break;
                        }
                        sum += board[x][y];
                    }
                    if (valid) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}