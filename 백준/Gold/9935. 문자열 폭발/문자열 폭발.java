import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, answer, max;
    static int[] arr, dp;
    static boolean isSelected;
    static String target;
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        st = new StringTokenizer(br.readLine());
        target = st.nextToken();
        for(int i=0;i<text.length();i++) {
            stack.push(text.charAt(i));
            if(stack.size()>=target.length()) {
                boolean flag = true;
                for(int j=0;j<target.length();j++) {
                    if(stack.get(stack.size()-target.length()+j) != target.charAt(j)) {
                        flag=false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0;j<target.length();j++) {
                        stack.pop();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        if(stack.size()==0) {
            System.out.println("FRULA");
        } else {
            while (stack.size()!=0) {
                sb.append(stack.pop());
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
