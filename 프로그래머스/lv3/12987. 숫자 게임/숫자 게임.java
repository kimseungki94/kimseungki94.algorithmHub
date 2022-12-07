import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int index=0;
        for(int a : A) {
            if(index==B.length) break;
            while(true) {
                if(index==B.length-1) {
                    if(a<B[index]) answer++;
                    index++;
                    break;
                } else {
                    if(a<B[index]) {
                        index++;
                        answer++;
                        break;
                    } else {
                        index++;
                    }                    
                }
            }
        }
        return answer;
    }
}