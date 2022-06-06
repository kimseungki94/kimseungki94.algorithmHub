import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, count, max;
    static int[] arr;
    static String a, b;
    static char maxChar;
    static char[] ch;
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    static int sum;
    static String answer;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        while (!text.equals(".")) {
            answer="yes";
            for (char c : text.toCharArray()) {
                if (c != '(' && c != ')' && c != '[' && c != ']') {
                    continue;
                } else {
                    if(stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (c == '(' || c == '[') {
                            stack.push(c);
                        } else if (c == ')') {
                            if (stack.peek() == '(') {
                                stack.pop();
                            } else {
                                stack.push(c);
                            }
                        } else if (c == ']') {
                            if (stack.peek() == '[') {
                                stack.pop();
                            } else {
                                stack.push(c);
                            }
                        }
                    }
                }
            }
            if(stack.size()!=0) {
                answer="no";
            }
            stack.clear();
            text = br.readLine();
            System.out.println(answer);
        }
    }


    public static void main(String[] args) throws Exception {
        input();
    }
}
