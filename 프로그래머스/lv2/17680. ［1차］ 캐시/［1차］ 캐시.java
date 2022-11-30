import java.util.*;

class Solution {
    static Queue<String> queue = new LinkedList<String>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0) return 5*cities.length;
        init(cities);
        for(String s : cities) {
            if(search(s)) {
                answer+=1;
            } else {
                if(queue.size()>=cacheSize) queue.poll();

                queue.offer(s);
                answer+=5;
            }  
        }
        return answer;
    }
    
    public static void init(String[] cities) {
        for(int i=0;i<cities.length;i++) {
            cities[i] = cities[i].toUpperCase();
        }
    }
    
    public static boolean search(String data) {
        if(queue.isEmpty()) return false;
        Queue<String> tempQueue = new LinkedList<>();
        Queue<String> tempQueue2 = new LinkedList<>();
        for(String s : queue) {
            tempQueue2.offer(s);
        }
        boolean flag = false;
        String text="";
        for(String s : tempQueue2) {
            if(!flag && s.equals(data)) {
                text = queue.poll();
                flag=true;
            } else {
                tempQueue.offer(queue.poll());
            }
        }
        
        if(flag) {
            tempQueue.offer(text);
        }
        queue=tempQueue;
        return flag;
    }
}