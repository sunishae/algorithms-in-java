import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        int n = clothes.length;
        for (int i = 0; i < n; i++) {
            String s = clothes[i][1];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String s : map.keySet()) {
            answer *= (map.get(s) + 1);
        }
        
        return answer - 1;
    }
}