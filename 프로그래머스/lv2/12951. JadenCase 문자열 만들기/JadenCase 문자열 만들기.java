import java.util.*;

class Solution {
    static int size;
    public String solution(String s) {
        String[] words = s.split(" ");
        char end = s.charAt(s.length()-1);
        
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            char[] c = word.toCharArray();
            for(int i=0;i<c.length;i++) {
                if(Character.isAlphabetic(c[i])){
                    if(i==0) {
                        c[i]=Character.toUpperCase(c[i]);
                    } else if(i>0 && Character.isUpperCase(c[i]))
                        c[i]=Character.toLowerCase(c[i]);
                    }
                }  
            sb.append(c).append(" ");
        }
        String answer;
        if(end==' ') {
            answer =sb.toString();
        } else {
            answer =sb.toString().trim();
        }
        return answer;
    }
}