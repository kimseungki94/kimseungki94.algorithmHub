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
    static String answer;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }
        max = Integer.MIN_VALUE;
        int value;
        while (!stack.isEmpty()) {
            value = stack.pop();
            if (max < value) {
                max = value;
                count++;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        input();
        System.out.println(count);
    }
}
