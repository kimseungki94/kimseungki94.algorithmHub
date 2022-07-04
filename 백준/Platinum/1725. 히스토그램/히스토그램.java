import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+2];
        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        stack.push(0);
        int max = 0;
        for(int i=1;i<=N+1;i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if(arr[top]<=arr[i]) {
                    break;
                }
                stack.pop();
                max = Math.max(max,arr[top]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
    }
}
