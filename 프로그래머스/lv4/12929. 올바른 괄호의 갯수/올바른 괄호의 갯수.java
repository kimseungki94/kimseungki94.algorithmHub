import java.util.*;

class Solution {
    class Text {
        int open;
        int close;
        
        Text(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }
    public int solution(int n) {
        int answer = DFS(n,0);
        return answer;
    }
    
    private int DFS(int n, int answer) {
        Stack<Text> stack = new Stack<>();
        stack.push(new Text(0,0));
        while(!stack.isEmpty()) {
            Text text = stack.pop();
            if(text.open>n) continue;
            if(text.close>text.open) continue;
            if(text.open==n && text.close==n) {
                answer++;
                continue;
            }
            stack.push(new Text(text.open+1,text.close));
            stack.push(new Text(text.open,text.close+1));   
        }
        return answer;
    }
}