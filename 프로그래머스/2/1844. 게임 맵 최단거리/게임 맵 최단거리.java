import java.util.*;

class Solution {
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static class Point{
        int x, y, count;
        public Point(int x, int y, int count){
            this.x = x; this.y = y; this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;    // 세로
        int m = maps[0].length; // 가로
        
        visited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        
        // 시작점 설정 (0, 0)
        q.offer(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            // 목표 도달 시 즉시 리턴
            if(cur.x == n - 1 && cur.y == m - 1) {
                return cur.count;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                // 맵 범위 체크 및 방문/벽 체크
                if(nx >= 0 && nx < n && ny >= 0 && ny < m 
                   && !visited[nx][ny] && maps[nx][ny] == 1) {
                    
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, cur.count + 1));
                }
            }
        }
        
        return -1; // 도달할 수 없는 경우
    }
}