import java.util.*;

class Solution {
    static ArrayList<Data> list = new ArrayList<>();
    public class Data {
        String head;
        int number;
        String original;
        String tail;
        
        Data(String original, String head, int number, String tail) {
            this.original= original;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    public String[] solution(String[] files) {

        int index=0;
        for(String text : files) {
            boolean isCheckText1=false;
            boolean isCheckText2=false;
            String head="";
            String number="";
            String tail="";
            for(char c : text.toCharArray()) {
                if(!isCheckText1 && Character.isDigit(c)) {
                    isCheckText1=true;
                } else if(isCheckText1 && !Character.isDigit(c)) {
                    isCheckText2=true;
                }
                
                if(isCheckText1 && isCheckText2) {
                    tail+=Character.toUpperCase(c);
                } else if(isCheckText1) {
                    number+=c;
                } else {
                    head+=Character.toUpperCase(c);
                }   
            }
            list.add(new Data(text, head,Integer.parseInt(number),tail));
            index++;
        }
        Collections.sort(list,(o1,o2) -> {
            if(o1.head.equals(o2.head)) {
                return o1.number-o2.number;
            }
            else return o1.head.compareTo(o2.head);
        });
        String[] answer = new String[files.length];
        for(int i=0;i<files.length;i++) {
            answer[i]=list.get(i).original;
        }
        
        return answer;
    }
}