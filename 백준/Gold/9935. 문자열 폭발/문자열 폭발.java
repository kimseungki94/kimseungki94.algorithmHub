import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long cnt;
    static String text;
    static String key;
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        input();
        Solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        text = st.nextToken();
        st = new StringTokenizer(br.readLine());
        key = st.nextToken();
    }
    public static void Solution() {
        for(char c : text.toCharArray()) {
            stack.push(c);
            while(stack.size()>=key.length() && stack.get(stack.size()-1)==key.charAt(key.length()-1)) {
                if(isChecked()) {
                    for(int i=0;i<key.length();i++) {
                        stack.pop();
                    }
                } else {
                    break;
                }
            }
        }
        if(stack.size()==0) {
            System.out.println("FRULA");
        } else {
            for(int i=0;i<stack.size();i++) {
                sb.append(stack.get(i));
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean isChecked() {
        int index=0;
        for(int i=stack.size()-key.length();i<stack.size();i++) {
            if(stack.get(i)!=key.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }
}