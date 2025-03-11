import java.util.*;
import java.math.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        BigInteger pValue = new BigInteger(p);
        
        for(int i = 0; i <= t.length() - p.length(); i++){
            String temp = t.substring(i,i+p.length());
            BigInteger tValue = new BigInteger(temp);
            
            if(tValue.compareTo(pValue) <= 0) answer++;
        }
        return answer;
    }
}