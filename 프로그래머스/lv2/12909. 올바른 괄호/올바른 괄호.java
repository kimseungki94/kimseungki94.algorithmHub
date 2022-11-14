import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c==')') {
                if(stack.isEmpty() || stack.peek()==')') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);    
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}