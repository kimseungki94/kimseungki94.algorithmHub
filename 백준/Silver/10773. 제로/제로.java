import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, count, max;
    static int[] arr;
    static String a, b;
    static char maxChar;
    static char[] ch;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    static int sum;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int value = 0;
        for (int i = 0; i < N; i++) {
            value = Integer.parseInt(br.readLine());
            if (value > 0) {
                stack.push(value);
                sum += value;
            } else {
                if (!stack.isEmpty()) {
                    sum -= stack.pop();
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sum);
    }
}
