import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int value=0;
        int turn=1;
        String answer = "";
        
        while(answer.length()!=t) {
            int tempValue = value++;
            String data = Integer.toString(tempValue,n).toUpperCase();
            for(int i=0;i<data.length();i++) {
                if(turn==p) {
                    answer+=data.charAt(i);
                }
                turn++;
                if(turn>m) {
                    turn%=m;
                }
                if(answer.length()==t) {
                    break;
                }
            }
        }
        return answer;
    }
}