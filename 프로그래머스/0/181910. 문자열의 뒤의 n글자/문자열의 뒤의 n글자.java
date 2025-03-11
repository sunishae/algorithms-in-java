class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int len = my_string.length();
        answer = my_string.substring(len - n, len);
        return answer;
    }
}