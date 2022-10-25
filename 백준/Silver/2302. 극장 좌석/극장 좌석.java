import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int value = 1;
        int beforeSeat = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            value *= dp[temp - beforeSeat - 1];
            beforeSeat = temp;
        }
        value *= dp[N - beforeSeat];
        System.out.println(value);

    }
}