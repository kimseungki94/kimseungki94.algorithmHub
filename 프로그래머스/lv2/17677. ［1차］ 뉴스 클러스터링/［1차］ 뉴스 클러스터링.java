import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        HashMap<String,Integer> hashMapA = new HashMap<>();
        HashMap<String,Integer> hashMapB = new HashMap<>();
        int answer = 0;
        
        for(char c : str1.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                char value = Character.toUpperCase(c);
                sb1.append(value);
            } else {
                sb1.append(c);
            }
        }
        
        for(char c : str2.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                sb2.append(Character.toUpperCase(c));
            } else {
                sb2.append(c);
            }
        }
        str1 = sb1.toString();
        str2 = sb2.toString();
        for(int i=1;i<str1.length();i++) {
            char a = str1.charAt(i-1);
            char b = str1.charAt(i);
            if(Character.isAlphabetic(a) && Character.isAlphabetic(b)) {
                String value = str1.substring(i-1,i+1);
                hashMapA.put(value,hashMapA.getOrDefault(value,0)+1);
            }
        }
        for(int i=1;i<str2.length();i++) {
            char a = str2.charAt(i-1);
            char b = str2.charAt(i);
            if(Character.isAlphabetic(a) && Character.isAlphabetic(b)) {
                String value = str2.substring(i-1,i+1);
                hashMapB.put(value,hashMapB.getOrDefault(value,0)+1);
            }
        }
        double max = 0;
        double min = 0;
        for(String key : hashMapA.keySet()) {
            if(hashMapB.containsKey(key)) {
                min+=Math.min(hashMapA.get(key),hashMapB.get(key));
                max+=Math.max(hashMapA.get(key),hashMapB.get(key));
            } else {
                max+=hashMapA.get(key);
            }
        }
        
        for(String key : hashMapB.keySet()) {
            if(!hashMapA.containsKey(key)) {
                max+=hashMapB.get(key);
            }
        }
        double data;
        if(max==0.0 && min==0.0) {
            data=1;
        } else {
            data = min/max;
        }
        answer = (int)(data*65536);
        return answer;
    }
}

/*
1. 데이터 들어온걸 받기 전 알파벳만 가져온다.
aa aa 2
3
*/
