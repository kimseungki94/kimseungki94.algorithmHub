import java.util.*;

class Solution {
    static PriorityQueue<Integer> pQ = new PriorityQueue<>();
    static PriorityQueue<Integer> reversepQ = new PriorityQueue<>(Collections.reverseOrder());
    
    public int[] solution(String[] operations) {
        
        int[] answer = new int[2];
        
        for(String text : operations) {
            StringTokenizer st = new StringTokenizer(text);
            if(st.nextToken().equals("I")) {
                int value = Integer.parseInt(st.nextToken());
                pQ.add(value);
                reversepQ.add(value);
            } else {
                if(pQ.size()!=0) {
                    int flag = Integer.parseInt(st.nextToken());
                    if(flag==1) {
                        pQ.remove(reversepQ.poll());
                    } else {
                        reversepQ.remove(pQ.poll()); 
                    }
                }
            } 
        }
        
        if(pQ.size()!=0) {
            answer[0]=reversepQ.poll();
            answer[1]=pQ.poll();
        } else {
            answer[0]=0;
            answer[1]=0;
        }
        
        
        return answer;
    }
}