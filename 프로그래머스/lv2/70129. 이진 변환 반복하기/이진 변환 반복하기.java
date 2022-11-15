import java.util.*;

class Solution {
    static int zeroCount;
    static int count;
    
    public int[] solution(String s) {
        while(!s.equals("1")) {
            count++;
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()) {
                if(c=='0') {
                    zeroCount++;
                } else {
                    sb.append(c);
                }
            }
            s=Integer.toBinaryString(sb.toString().length());
        }
        
        int[] answer = {count, zeroCount};
        return answer;
    }
}