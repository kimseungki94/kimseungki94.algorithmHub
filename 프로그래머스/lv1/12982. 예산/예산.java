import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 1;
        int size = d.length;
        Arrays.sort(d);
        if(d[0]>budget) return 0;
        for(int i=1;i<size;i++) {
            d[i]+=d[i-1];
            if(d[i]<=budget) answer++;
        }
        System.out.println(Arrays.toString(d));
        
        return answer;
    }
}
/**
1000원 신청
1000원 지원, 더 적은 금액 지원불가

*/