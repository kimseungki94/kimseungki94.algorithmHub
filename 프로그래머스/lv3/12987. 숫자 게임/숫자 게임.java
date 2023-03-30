import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); //1 3 5 7
        Arrays.sort(B); // 2 2 6 8
        int answer=0;
        int index=0;
        int size = A.length;
        for(int i=0;i<size;i++) {
            if(index==size) {
                break;
            }
            while(index!=size) {
                if(A[i]<B[index]) {
                    answer++;
                    index++;
                    break;
                }
                index++;
            }
        }
        return answer;
    }
    
}
/**
숫자게임진행
A팀의 출전순서를 보고 B팀이 최대한 승점을 얻는 방법

*/