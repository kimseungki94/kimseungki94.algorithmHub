import java.util.*;

class Solution {
    static int[] arr;
    
    public int solution(int n) {
        int answer = 0;
        arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;
        answer = fibo(n);
        return answer;
    }
    
    public static int fibo(int data) {
        if(arr[data]!=0) {
            return arr[data];
        }
        return arr[data]=(fibo(data-2)+fibo(data-1))%1234567;
    }
}