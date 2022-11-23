import java.util.*;

class Solution {
    static int man=1;
    static int count=1;
    static ArrayList<String> list = new ArrayList<>();
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        list.add(words[0]);
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
        if(list.contains(after)) return false;
        if(before.charAt(before.length()-1)!=after.charAt(0)) return false;
        list.add(after);
        return true;
    }
}