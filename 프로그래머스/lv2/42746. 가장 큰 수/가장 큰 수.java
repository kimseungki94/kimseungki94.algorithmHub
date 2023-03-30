import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer= new StringBuilder();
        int size = numbers.length;
        String[] list = new String[size];
        boolean flag = true;
        for(int i=0;i<size;i++) {
            list[i]=String.valueOf(numbers[i]);
            if(numbers[i]!=0) flag=false; 
        }
        Arrays.sort(list, (o1,o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });
        for(int i=0;i<size;i++) {
            answer.append(list[i]);
        }
        if(flag) return "0";
        return answer.toString();
    }
}