import java.util.*;

class Solution
{
    static Stack<Character> stack = new Stack<>();
    public int solution(String s)
    {
        int answer = -1;
        
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek()==c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()) {
            answer=1;
        } else {
            answer=0;
        }

        return answer;
    }
}