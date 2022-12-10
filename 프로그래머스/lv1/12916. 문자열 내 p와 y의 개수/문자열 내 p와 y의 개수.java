import java.util.*;

class Solution {
    static int p,y;
    boolean solution(String s) {
        boolean answer = false;
        for(char c : s.toCharArray()) {
            if(Character.toUpperCase(c)=='P') {
                p++;
            } else if(Character.toUpperCase(c)=='Y'){
                y++;
            }
            
        }
        if(p==y) {
            return true;
        }
        return answer;
    }
}