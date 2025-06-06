import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;	//회전할 배열
	static int N,M,R;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	int space = Math.min(N, M)/2;		//공간 개수
    	arr = new int[N][M];
        //배열 초기화
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		for(int j=0;j<M;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	//기준
    	int n = N;
    	int m = M;
        //크기
    	int width = N;
    	int weight = M;
    	for(int i=0;i<space;i++) {
    		rotation(i,n,m,width,weight);
            //기준 감소
    		n-=1;
    		m-=1;
            //크기 감소
    		width-=2;
    		weight-=2;
    	}
        //회전한 후 배열값들 BufferedWriter 저장
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			bw.write(arr[i][j] + " ");
    		}
    		bw.newLine();
    	}
    	bw.flush();		//결과 출력
    	bw.close();
    	br.close();
    }
    //각 범위별 (R%원상태로 돌아오는 회전 횟수)번 회전하는 함수
    static void rotation(int space, int n, int m, int width, int weight) {
    	int repeat = R % (width*2 + weight*2 - 4);		//원상태로 돌아오는 회전 횟수
    	for(int i=0;i<repeat;i++) {
        	int temp = arr[space][space];
    		for(int j=space;j<m-1;j++)		//←
    			arr[space][j] = arr[space][j+1];  		
    		for(int j=space;j<n-1;j++)		//↑
    			arr[j][m-1] = arr[j+1][m-1];
    		for(int j=m-1;j>space;j--)		//→
    			arr[n-1][j] = arr[n-1][j-1];
    		for(int j=n-1;j>space;j--)		//↑
    			arr[j][space] = arr[j-1][space];
    		arr[space+1][space] = temp;
    	}
    	return;
    }
}