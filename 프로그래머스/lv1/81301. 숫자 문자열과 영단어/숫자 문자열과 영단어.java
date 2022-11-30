import java.util.*;

class Solution {
    static HashMap<String,Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public int solution(String s) {
        init();
        String value = "";
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                value+=c;
            } else {
                sb.append(c);
                if(map.getOrDefault(sb.toString(),-1)!=-1) {
                    value+=map.get(sb.toString());
                    sb.delete(0,sb.length());
                }
            }
        }
        return Integer.parseInt(value);
    }
    
    public static void init() {
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
    }
}