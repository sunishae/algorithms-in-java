class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;

        myString = myString.replaceAll("A", "t")
                           .replaceAll("B", "A")
                           .replaceAll("t", "B");

        if (myString.contains(pat)) answer = 1;

        return answer;
    }
}
