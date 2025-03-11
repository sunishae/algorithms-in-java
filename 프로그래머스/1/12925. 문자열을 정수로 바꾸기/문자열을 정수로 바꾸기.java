class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean flag = true;
        if(s.charAt(0) == '+'){
            s = s.substring(1);
            answer = Integer.parseInt(s);
        } else if(s.charAt(0) == '-'){
            s = s.substring(1);
            answer = 0 - Integer.parseInt(s);
        } else{
            answer = Integer.parseInt(s);
        }
        
        
        return answer;
    }
}