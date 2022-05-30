import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, count;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] arr = new int[]{1, 5, 10, 50};
    static boolean visit[] = new boolean[1001];

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void func(int limit, int value, int index) {
        if (limit == N) {
            if (visit[value] == false) {
                count++;
                visit[value] = true;
            }
            return;
        }
        for (int i = index; i < 4; i++) {
            func(limit + 1, value + arr[i], i);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func(0, 0, 0);
        System.out.println(count);
    }
}
