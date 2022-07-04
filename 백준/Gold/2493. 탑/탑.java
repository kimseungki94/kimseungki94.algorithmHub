import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static Stack<int[]> stack = new Stack<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            int data = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if(stack.peek()[1]<data) stack.pop();
                else {
                    sb.append(stack.peek()[0]+" ");
                    break;
                }
            }
            if(stack.isEmpty()) sb.append(0+" ");
            stack.push(new int[]{i,data});
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
    }
}
