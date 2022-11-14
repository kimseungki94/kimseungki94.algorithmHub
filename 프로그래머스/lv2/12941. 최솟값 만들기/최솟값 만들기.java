import java.util.*;

class Solution
{
    static int[] arr;
    static boolean[] isChecked;
    static int size;
    
    
    public int solution(int []A, int []B)
    {
        int answer=0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++) {
            answer+=A[i]*B[B.length-1-i];
        }
        return answer;
    }
}