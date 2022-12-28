import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pQ = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        Arrays.sort(jobs,(o1,o2) -> o1[0]-o2[0]);
        int end=0;
        int index=0;
        int count=0;
        while(count<jobs.length) {
            while(index<jobs.length && jobs[index][0]<=end) {
                pQ.offer(jobs[index++]);
            }
            
            if(pQ.isEmpty()) {
                end=jobs[index][0];
            } else {
                int[] data = pQ.poll();
                answer+=data[1]-data[0]+end;
                end+=data[1];
                count++;
            }
        }  
        return (int)Math.floor(answer/jobs.length);
    }
}