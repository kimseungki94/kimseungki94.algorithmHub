import java.util.*;

class Solution {
    static HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int solution(int[] arr) {
        int answer = 1;
        for(int a : arr) {
            divide(a);
        }
        for(int a : hashMap.keySet()) {
            for(int i=0;i<hashMap.get(a);i++) {
                answer*=a;
            }
        }
        
        return answer;
    }
    
    public static void divide(int n) {
        for(int i=2;i<=n;i++) {
            int count=0;
            while(n%i==0) {
                n=n/i;
                count++;
            }
            if(hashMap.getOrDefault(i,0)<count) {
                hashMap.put(i,count);
            }
            if(n==1) break;
        }
    }
}