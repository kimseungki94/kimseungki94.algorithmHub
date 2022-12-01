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
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for(String s : queue) {
            temp.add(s);
        }
        boolean flag = false;
        String text="";
        for(String s : temp) {
            if(!flag && s.equals(data)) {
                text = queue.poll();
                flag=true;
            } else {
                list.add(queue.poll());
            }
        }
        
        if(flag) {
            list.add(text);
        }
        for(String s : list) {
            queue.offer(s);
        }
        return flag;
    }
}