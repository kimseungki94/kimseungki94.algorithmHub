import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, count;
    static String text, answer;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }
    }

    public void Solution() {
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            if (stack.size() % 2 != 0) continue;
            for (char c : arr[i].toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty() && stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) count++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
        System.out.println(count);
    }
}
