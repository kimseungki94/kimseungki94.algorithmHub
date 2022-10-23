import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(dp[N - 2][arr[N - 1]]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new long[N][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void Solution() {
        dp[0][arr[0]] = 1;
        int plus;
        int minus;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    plus = j + arr[i];
                    minus = j - arr[i];
                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }
    }

}