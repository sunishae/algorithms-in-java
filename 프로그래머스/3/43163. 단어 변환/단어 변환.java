import java.util.*;

class Solution {
    
    public static class Word{
        String name;
        int cnt;
        
        public Word(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        int answer = bfs(begin, target, words);
        
        return answer;
    }
    
    public static int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        int result = 0;
        while(!q.isEmpty()) {
            Word current = q.poll();
            int curIdx = current.cnt;
            
            if (current.name.equals(target)) {
                result = curIdx;
                break;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && check(current.name, words[i])) {
                    q.add(new Word(words[i] , curIdx + 1));
                    visited[i] = true;
                }
            }
        }
        
        return result;
    }
    
    public static boolean check(String current, String next) {
        int cnt = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == next.charAt(i)) {
                cnt++;
            }
        }
        
        if (cnt == current.length() - 1) {
            return true;
        } else {
            return false;
        }
    }
}