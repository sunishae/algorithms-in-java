import java.util.*;

class Solution {
    public static class Job {
        int number;
        int priority;
        
        public Job (int number, int priority) {
            this.number = number;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Job> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Job(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        
        int idx = 1;
        while (!q.isEmpty()) {
            int maxPriority = pq.peek();
            
            while (q.peek().priority < maxPriority) {
                q.offer(q.poll());
            }
            
            pq.poll();
            Job outJob = q.poll();
            System.out.println("out : " + outJob.priority + outJob.number);
            
            if (outJob.number == location) {
                break;
            }
            idx++;
        }
        
        
        return idx;
    }
}