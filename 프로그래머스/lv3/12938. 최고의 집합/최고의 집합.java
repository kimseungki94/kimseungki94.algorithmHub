import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        if(n>s) {
            answer = new int[1];
            answer[0]=-1;
            return answer;
        } else {
            answer = new int[n];
            int value = s/n;
            int plusValue = s%n;
            Arrays.fill(answer,value);
            for(int i=n-1;i>n-1-plusValue;i--) {
                answer[i]++;
            }
        }
        return answer;
    }
}