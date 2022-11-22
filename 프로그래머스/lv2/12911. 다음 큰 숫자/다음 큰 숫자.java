import java.util.*;

class Solution {
    static int count;
    
    public int solution(int n) {
        int answer = n+1;
        for(char c : Integer.toBinaryString(n).toCharArray()) {
            if(c=='1') count++;
        }
        while(!validation(answer)) {
            answer++;
        }
        return answer;
    }
    
    public static boolean validation(int a) {
        int data=0;
        for(char c : Integer.toBinaryString(a).toCharArray()) {
            if(c=='1') data++;
        }
        if(count==data) {
            return true;
        }
        return false;
    }
}

