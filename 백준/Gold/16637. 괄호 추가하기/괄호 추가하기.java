import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String t = br.readLine();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                num.add(t.charAt(i) - '0');
            } else {
                op.add(t.charAt(i));
            }
        }
        int start = num.get(0);
        DFS(0, start);
        System.out.println(max);
    }

    public static void DFS(int index, int sum) {
        if (index >= op.size()) {
            max = Math.max(max, sum);
            return;
        }
        int one = cal(index, sum, num.get(index + 1));
        DFS(index + 1, one);
        if (index + 1 < op.size()) {
            int two = cal(index + 1, num.get(index + 1), num.get(index + 2));
            int result = cal(index, sum, two);
            DFS(index + 2, result);
        }
    }

    public static int cal(int index, int a, int b) {
        switch (op.get(index)) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 1;
    }
}