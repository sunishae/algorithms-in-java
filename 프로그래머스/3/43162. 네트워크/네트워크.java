import java.util.*;

class Solution {
    static int[] computer; 
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        computer = new int[n];
        visited = new boolean[n];
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문한적 없음
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                
                while(!q.isEmpty()) {
                    int curIdx = q.poll();
                    
                    for (int j = 0; j < n; j++) {
                        if(computers[curIdx][j] == 1 && !visited[j]) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}