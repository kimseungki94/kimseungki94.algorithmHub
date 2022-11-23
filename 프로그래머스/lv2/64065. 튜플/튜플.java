import java.util.*;

class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> solution(String s) {
        String data = s.replace("{{","").replace("}}","").replace("},{","-");
        String[] text = data.split("-");
        Arrays.sort(text, (o1,o2) -> o1.length()-o2.length());
        for(String value : text) {
            for(String t : value.split(",")) {
                int a = Integer.parseInt(t);
                if(!list.contains(a)) {
                    list.add(a);
                }
            }
        }
        return list;
    }
}