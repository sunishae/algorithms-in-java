class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        // 키패드의 좌표 설정 (1~9, *, 0, #의 위치)
        int[][] keypad = {
            {3, 1}, // 0
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0}, {3, 2} // *, #
        };
        
        int[] leftPos = keypad[10]; // *의 위치
        int[] rightPos = keypad[11]; // #의 위치
        
        for (int num : numbers) {
            int[] targetPos = keypad[num]; // 현재 눌러야 할 키의 좌표
            
            // 왼쪽 키패드(1, 4, 7)
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftPos = targetPos;
            } 
            // 오른쪽 키패드(3, 6, 9)
            else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightPos = targetPos;
            } 
            // 가운데 키패드(2, 5, 8, 0)
            else {
                int leftDistance = Math.abs(leftPos[0] - targetPos[0]) + Math.abs(leftPos[1] - targetPos[1]);
                int rightDistance = Math.abs(rightPos[0] - targetPos[0]) + Math.abs(rightPos[1] - targetPos[1]);
                
                if (leftDistance < rightDistance) {
                    answer.append("L");
                    leftPos = targetPos;
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    rightPos = targetPos;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = targetPos;
                    } else {
                        answer.append("R");
                        rightPos = targetPos;
                    }
                }
            }
        }
        
        return answer.toString();
    }
}