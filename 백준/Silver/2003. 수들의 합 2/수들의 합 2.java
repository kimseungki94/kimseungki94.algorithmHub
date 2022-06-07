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
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[Integer.parseInt(st.nextToken())];
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt, rt, sum;
        lt = rt = sum = 0;
        while (rt != arr.length) {
            if (sum >= N) {
                sum -= arr[lt++];
            } else if (sum < N) {
                sum += arr[rt++];
            }
            if (sum == N) {
                count++;
            }
        }
        while (rt>lt) {
            sum-=arr[lt++];
            if(sum==N) {
                count++;
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception {
        input();
    }
}
