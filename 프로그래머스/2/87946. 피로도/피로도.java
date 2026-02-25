class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    // k : 현재 피로도 1~5000
    // dungeons : [1 ~ 8][최소 필요 피로도, 소모 피로도]
    // 최소 피로도 >= 소모 피로도 : 생각해보면 당연?
    public int solution(int k, int[][] dungeons) {
        // 던전이 최대 8개라 아무리 많이 돌아도 경우의 수는 8!
        // 관건은 던전을 가는 행위를 어떻게 하냐.
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);     
        
        return answer;
    }
    
    public static void dfs(int count, int fatique, int[][] dungeons) {
        answer = Math.max(count, answer);
        
        for(int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatique >= dungeons[i][0]) {
                visited[i] = true;
                dfs(count + 1, fatique - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}