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
            answer = "yes";
            for (char c : text.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        answer = "no";
                        stack.push(c);
                        break;
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        answer = "no";
                        stack.push(c);
                        break;
                    }
                }
            }
            if (stack.size() != 0) {
                answer = "no";
            } else {
                answer = "yes";
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
