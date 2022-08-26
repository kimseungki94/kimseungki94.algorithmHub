import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int jCount, mCount;
    static int[] arrTwo, arrFive, map;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(sb.toString());
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Character> stack = new Stack<>();
        while (true) {
            st = new StringTokenizer(br.readLine(),"");
            String text = st.nextToken();
            if(text.equals(".")) break;
            boolean flag=true;
            for(char c : text.toCharArray()) {
                if(c==')') {
                    if(stack.isEmpty() || stack.peek()!='(') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                else if(c==']') {
                    if(stack.isEmpty() || stack.peek()!='[') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                else if(c=='(' || c=='['){
                    stack.push(c);
                }
            }
            if(!stack.isEmpty()) flag=false;
            if(flag) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
            stack.clear();
        }
    }

    public void Solution() {
    }
}
