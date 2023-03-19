import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] stringArray=new String[numbers.length];
        int size = numbers.length;
        boolean except =true;
        for(int i=0;i<size;i++) {
            stringArray[i]=String.valueOf(numbers[i]);
            if(numbers[i] != 0) except = false;
        }
        Arrays.sort(stringArray,(o1,o2)-> {
            return (o1+o2).compareTo(o2+o1);
        });
        
        for(int i=size-1;i>=0;i--) {
            answer+=stringArray[i];
        }
        if(except) return "0";
        return answer;
    }
}