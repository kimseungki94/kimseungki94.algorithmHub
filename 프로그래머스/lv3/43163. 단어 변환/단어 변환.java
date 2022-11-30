import java.util.*;

class Solution {
    static boolean isVisited[];
    static int answer;
    static int size;
    public int solution(String start, String target, String[] words) {    
        answer = Integer.MAX_VALUE;
        size = words.length;
        for (int i = 0; i < words.length; i++) {
            if(compare(start, words[i]) <= 1) {
                isVisited = new boolean[size];
                isVisited[i] = true;
                DFS(1, i, target, words);
            }
        }
 
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
 
    public static void DFS(int cnt, int cur, String target, String[] words) {
        if(target.equals(words[cur])) {
            answer = Math.min(cnt, answer);
            return;
        }
 
        for (int i = 0; i < size; i++) {
            if(!isVisited[i] && compare(words[cur], words[i]) == 1) {
                isVisited[i] = true;
                DFS(cnt + 1, i, target, words);
                isVisited[i] = false;
            }
        }
    }
 
    public static int compare(String s1, String s2) {
        int n = 0;
        for (int i = 0; i < s1.length(); i++) 
            if(s1.charAt(i) != s2.charAt(i))
                n++;
 
        return n;
    }
}