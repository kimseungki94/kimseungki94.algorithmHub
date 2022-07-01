import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, answer, max;
    static int[] arr, dp;
    static boolean isSelected;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        int lt, rt;
        int limit = M;
        int size = N - M;

        for (int i = 0; i < N; i++) {
            int data = text.charAt(i) - '0';
            while (!stack.isEmpty() && limit > 0 && stack.peek() < data) {
                stack.pop();
                limit--;
            }
            stack.push(data);
        }
        while (stack.size()!=size) {
            stack.pop();
        }
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        System.out.println(sb.reverse().toString());
    }
}
