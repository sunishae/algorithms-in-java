import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        
        // 각 작업별 소요 일자를 차례대로 addQ
        int len = progresses.length;
        for(int i = 0; i < len; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int time = (100 - progress + speed - 1) / speed;
            q.offer(time);
        }
        
        q.offer(Integer.MAX_VALUE);
        
        // peek()를 기준으로 이보다 작거나 같으면 cnt++
        while(true) {
            int cnt = 0;
            int curMax = q.peek();
            if (curMax == Integer.MAX_VALUE) {
                break;
            }
            
            while(curMax >= q.peek()) {
                q.poll();
                cnt++;
            }
            
            resultList.add(cnt);
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}