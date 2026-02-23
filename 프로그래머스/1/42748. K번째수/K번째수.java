import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> resultList = new ArrayList<>();
        int t = commands.length;
        
        for(int i = 0; i < t; i++) {
            int start = commands[i][0] - 1; // 시작지점
            int end = commands[i][1];
            int k = commands[i][2] - 1;
            
            int[] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);
            
           resultList.add(arr[k]);
        }
        
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}