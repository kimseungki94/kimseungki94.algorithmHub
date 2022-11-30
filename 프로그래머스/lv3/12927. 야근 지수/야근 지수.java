import java.util.*;

class Solution {
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

    public long solution(int n, int[] works) {
        
        for (int work : works) {
            pQ.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            int max = (int)pQ.poll();
            if (max <= 0) break;
            pQ.offer(max - 1);
        }
        long answer = 0;
        while (!pQ.isEmpty()) {
            answer += Math.pow(pQ.poll(), 2);
        }
        return answer;
    }
    
}