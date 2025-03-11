class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        
        for(char c : s.toCharArray()){
            if(c == 'p') pCnt++;
            else if(c == 'y') yCnt++;
        }

        return pCnt == yCnt;
    }
}