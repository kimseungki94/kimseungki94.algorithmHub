import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String a = Integer.toString(n);
        for(char c : a.toCharArray()) {
            answer+=c-'0';
        }

        return answer;
    }
}