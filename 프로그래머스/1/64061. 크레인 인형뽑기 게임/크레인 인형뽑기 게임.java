import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            int grab = move - 1; // 인덱스 보정
            int cur = 0; // 현재 선택된 인형
            
            // 인형을 찾는 과정
            for (int i = 0; i < board.length; i++) {
                if (board[i][grab] != 0) {
                    cur = board[i][grab];
                    board[i][grab] = 0; // 인형 제거
                    break;
                }
            }
            
            // 유효한 인형만 스택에 넣기
            if (cur == 0) continue;
            
            // 같은 인형이면 터뜨리기
            if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                answer += 2; // 두 개가 없어지므로 +2
            } else {
                stack.push(cur);
            }
        }
        
        return answer;
    }
}
