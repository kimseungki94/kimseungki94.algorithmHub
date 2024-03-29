import java.util.*;

class Solution {
    static int man=1;
    static int count=1;
    static HashMap<String,String> map = new HashMap<>();
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        map.put(words[0],words[0]);
        for(int i=1;i<words.length;i++) {
            man++;
            if(man>n) {
                man=1;
                count++;
            }
            if(isChecked(words[i-1],words[i])) {
                continue;
            } else {
                answer[0]=man;
                answer[1]=count;
                return answer;
            }
        }
        answer[0]=0;
        answer[1]=0;
        return answer;
    }
    
    public static boolean isChecked(String before, String after) {
        if(map.getOrDefault(after,"0").equals(after)) return false;
        if(before.charAt(before.length()-1)!=after.charAt(0)) return false;
        map.put(after,after);
        return true;
    }
}