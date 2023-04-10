import java.util.*;

class Solution {
    public boolean solution(int x) {
        int h=0;
        for(char c : String.valueOf(x).toCharArray()) {
            h+=c-'0';
        }
        boolean answer = true;
        if(x%h!=0) answer = false;
        return answer;
    }
}