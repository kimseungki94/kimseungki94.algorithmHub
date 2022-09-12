import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K, T, max;
    static int[][] map;
    static char[] arr;
    static String command;
    static boolean[][] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N];
        st = new StringTokenizer(br.readLine());
        arr = st.nextToken().toCharArray();
        Solution();
    }
    public static void Solution() {
        Stack<Integer> stack = new Stack<>();
        int count=0;
        stack.push(-1);
        for(int i=0;i<N;i++) {
            if(arr[i]=='(') {
                stack.push(i);
            } else {
                stack.pop();
                if(!stack.isEmpty()) {
                    max=Math.max(max,i-stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        max = Math.max(count*2,max);
        System.out.println(max);
    }
}