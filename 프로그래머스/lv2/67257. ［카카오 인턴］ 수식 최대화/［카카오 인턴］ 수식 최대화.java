import java.util.*;

class Solution {
    static char[] prior = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static ArrayList<Long> nums = new ArrayList<Long>();
    static ArrayList<Character> ops = new ArrayList<Character>();
    static long answer;
    
    public long solution(String expression) {
        answer = 0;

        String num="";
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                num += c;
            }else{
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(c);
            }
        }
        nums.add(Long.parseLong(num));
        DFS(0, new char[3]);

        return answer;
    }
    
    public static Long calc(Long num1, Long num2, char op){
        long num = 0;
        switch (op){
            case '+' : {
                return num1 + num2;
            }
            case '-' : {
                return num1 - num2;
            }
            case '*' : {
                return num1 * num2;
            }
        }
        return num;
    }

    public static void DFS(int count, char[] p){
        if(count == 3){
            ArrayList<Long> cNums = new ArrayList<>(nums);
            ArrayList<Character> cOps = new ArrayList<Character>(ops);

            for(int i=0;i<p.length;i++){
                for(int j=0; j< cOps.size(); j++){
                    if(p[i] == cOps.get(j)){
                        Long res = calc(cNums.remove(j), cNums.remove(j), p[i]);
                        cNums.add(j, res);
                        cOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNums.get(0)));
            return;

        }

        for(int i=0; i< 3; i++){
            if(!check[i]){
                check[i] = true;
                p[count] = prior[i];
                DFS(count+1,p);
                check[i] = false;
            }
        }
    }
}