import java.util.*;

class Solution {
    /**
    * bridge_length : 다리에 올라갈 수 있는 최대 트럭 수
    * weight : 다리가 버틸 수 있는 무게
    * truck_weights : 트럭 무게 리스트
    */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            wait.offer(truck_weights[i]);
        }
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        while (!bridge.isEmpty()) {
            time++;
            currentWeight -= bridge.poll();
            
            if (!wait.isEmpty()) {
                if (currentWeight + wait.peek() <= weight) {
                    int nextTruck = wait.poll();
                    bridge.offer(nextTruck);
                    currentWeight += nextTruck;
                } else {
                    bridge.offer(0);
                }
            }
        }
        
        return time;
    }
}