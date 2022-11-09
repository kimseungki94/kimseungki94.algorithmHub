import java.util.*;

class Solution {

    public String solution(String s) {
        String[] words = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String word : words) {
            int value  = Integer.parseInt(word);
            max = Math.max(max,value);
            min = Math.min(min,value);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        String answer = sb.toString();
        return answer;
    }
}